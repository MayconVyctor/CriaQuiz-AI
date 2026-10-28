package com.criaquiz.infrastructure.adapters.out.ai;

import com.criaquiz.application.ports.out.AiQuizGeneratePort;
import com.criaquiz.domain.entities.Pergunta;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class GeminiAiAdapter implements AiQuizGeneratePort {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    @Value("${gemini.api.key:${ANTHROPIC_API_KEY:}}")
    private String apiKey;

    public GeminiAiAdapter() {
        this.restClient = RestClient.create();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public List<Pergunta> gerarPerguntas(String tema, String texto, int quantidadePerguntas) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + apiKey;

        String prompt = montarPrompt(tema, texto, quantidadePerguntas);

        Map<String, Object> requestBody = Map.of(
            "contents", List.of(
                Map.of("parts", List.of(
                    Map.of("text", prompt)
                ))
            ),
            "generationConfig", Map.of(
                "responseMimeType", "application/json"
            )
        );

        try {
            String response = restClient.post()
                .uri(url)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .retrieve()
                .body(String.class);

            JsonNode rootNode = objectMapper.readTree(response);
            String jsonPerguntas = rootNode
                .path("candidates").get(0)
                .path("content")
                .path("parts").get(0)
                .path("text").asText();

            List<Map<String, Object>> lista = objectMapper.readValue(
                jsonPerguntas,
                new TypeReference<List<Map<String, Object>>>() {}
            );

            List<Pergunta> perguntas = new ArrayList<>();
            for (Map<String, Object> item : lista) {
                perguntas.add(new Pergunta(
                    UUID.randomUUID().toString(),
                    (String) item.get("enunciado"),
                    (List<String>) item.get("alternativas"),
                    (String) item.get("alternativaCorreta"),
                    (String) item.get("explicacao")
                ));
            }

            return perguntas;

        } catch (Exception e) {
            throw new RuntimeException("Falha ao gerar perguntas com IA: " + e.getMessage(), e);
        }
    }

    private String montarPrompt(String tema, String texto, int quantidadePerguntas) {
        StringBuilder sb = new StringBuilder();
        sb.append("Você é um especialista educacional gerador de quizzes. ");
        sb.append("Gere exatamente ").append(quantidadePerguntas).append(" perguntas de múltipla escolha sobre o tema: ").append(tema).append(".\n");

        if (texto != null && !texto.isBlank()) {
            sb.append("Utilize o seguinte texto base de apoio: \"").append(texto).append("\".\n");
        }

        sb.append("Responda OBRIGATORIAMENTE em formato JSON como uma lista de objetos com o seguinte esquema:\n");
        sb.append("[\n");
        sb.append("  {\n");
        sb.append("    \"enunciado\": \"Texto da pergunta\",\n");
        sb.append("    \"alternativas\": [\"Alternativa A\", \"Alternativa B\", \"Alternativa C\", \"Alternativa D\"],\n");
        sb.append("    \"alternativaCorreta\": \"Alternativa A\",\n");
        sb.append("    \"explicacao\": \"Breve explicação do porquê está correta\"\n");
        sb.append("  }\n");
        sb.append("]\n");

        return sb.toString();
    }
}
