package japdp.damtf.security.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import japdp.damtf.security.authentication.dto.AuthenticationResponseDTO;
import japdp.damtf.security.authentication.dto.LoginRequestDTO;
import japdp.damtf.security.authentication.dto.RegisterRequestDTO;
import lombok.RequiredArgsConstructor;

/**
 * Controlador que maneja las operaciones relacionadas con la autenticación.
 */
@CrossOrigin
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private final AuthenticationService authentificationService;

	/**
	 * Maneja la solicitud de inicio de sesión.
	 *
	 * @param request DTO que contiene la información de inicio de sesión.
	 * @return Respuesta con el token de autenticación generado.
	 */
	@PostMapping("login")
	public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody LoginRequestDTO request) {
		LOGGER.info("Solicitud de login: {}",request.getUsername());   
		return ResponseEntity.ok(authentificationService.login(request));
	}

	/**
	 * Maneja la solicitud de registro de usuario.
	 *
	 * @param request DTO que contiene la información de registro.
	 * @return Respuesta con el token de autenticación generado.
	 */
	@PostMapping("register")
	public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO request) {
		LOGGER.info("Solicitud de registro: {}",request.getUsername());   
		return ResponseEntity.ok(authentificationService.register(request));
	}

}
