import { useState, useEffect } from 'react';
import * as network from '../Network.js';
import * as stack from "../Stack.js";

function DeleteProductPage(props) {

	const product = props.product;

	const [error, setError] = useState(null);

	function onClickGoBack(ev) {
		stack.goBack();
	}

	async function handleSubmit(ev) {
		ev.preventDefault();
		try {
			await network.deleteProduct(productId);
			stack.goBack2();
		}
		catch (err) {
			setError(err);
		}
	}

	/* Conditional rendering */

	if (error !== null) {
		return (
			<>
				<main>
					<p>Error: {error.message}</p>
				</main>
			</>
		);
	}
	else {

		return (
			<>
				<header><h1>Eliminando producto</h1></header>
				<main>
					<p className='mensaje'>{error === null ? <>&nbsp;</> : error.message}</p>
					<form onSubmit={handleSubmit}>
						<div>
							<label><b>Id</b></label>
							<input type="text" value={product.id} disabled />
						</div>
						<div>
							<label><b>Nombre</b></label>
							<input type="text" value={product.name} disabled />
						</div>
						<div>
							<label><b>Descripción</b></label>
							<input type="text" value={product.description} />
						</div>
						<div>
							<label><b>Precio</b></label>
							<input type="text" value={product.price} />
						</div>
						<input type="submit" value="Eliminar"/>
					</form>
				</main>
			</>
		);

	}
}

export default DeleteProductPage;
