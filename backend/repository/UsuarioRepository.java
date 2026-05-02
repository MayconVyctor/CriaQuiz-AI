
import com.criaquiz.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// JpaRepository<Entidade, TipoDoId>
// já vem com: save, findById, findAll, delete, count...
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Spring gera o SQL automaticamente pelo nome do método
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
}