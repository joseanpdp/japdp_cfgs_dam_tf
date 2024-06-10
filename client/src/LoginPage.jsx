import springLogo from "./assets/spring-logo.svg";
import reactLogo from "./assets/react-logo.png";
import vedrunaLogo from "./assets/vedruna.png";

import { useState, useEffect } from 'react';

import * as stack from "./Stack.js";
import * as network from "./Network.js";


function LoginPage(props) {

	const [user, setUser] = useState("");
	const [password, setPassword] = useState("");
	const [error, setError] = useState(null);

	stack.clearStack();

	function handleChangeUser(event) {
		setUser(event.target.value);
	}

	function handleChangePassword(event) {
		setPassword(event.target.value);
	}

	async function handleSubmit(ev) {
		ev.preventDefault();

		try {
			await network.getAuth({ username: user, password: password });
			stack.go({ name: "InitialPage", data: null });
		}
		catch (err) {
			setError("Usuario o contraseña incorrectos");
			await sleep(3000);
			setError("");
		}
	}

	return (
		<>
			<header>
				<h1>GSV</h1>
				<h3>Gestión Supermercado Vedruna</h3>
			</header>
			<main className="login">
				<form onSubmit={handleSubmit}>
					<div>
						<label>Usuario: </label>
						<input type="text" value={user} onChange={handleChangeUser} />
					</div>
					<div>
						<label>Contraseña: </label>
						<input type="password" value={password} onChange={handleChangePassword} />
					</div>
                    <div>
					    <input type="submit" value="Acceder" />
                    </div>
				</form>
				<p className='error'>{error}</p>
    			<div className="logos">
    				<img src={springLogo} /><img src={reactLogo} /><img src={vedrunaLogo} />
    			</div>
			</main>
		</>
	);
}

export default LoginPage;
