import { useState, useEffect } from 'react';
import * as network from '../Network.js';
import * as stack from "../Stack.js";

function DeleteOrderPage(props) {

	const order = props.order;

	const [error, setError] = useState(null);

	function onClickGoBack(ev) {
		stack.goBack();
	}

	async function handleSubmit(ev) {
		ev.preventDefault();
		try {
			await network.deleteOrder(order.id);
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
				<header><h1>Eliminando pedido</h1></header>
				<main>
					<form onSubmit={handleSubmit}>
						<div>
							<label><b>Id</b></label>
							<input type="text" value={order.id} disabled />
						</div>
						<div>
							<label><b>De</b></label>
							<input type="text" value={`${order.customerName} ${order.customerSurname}`} disabled />
						</div>
						<div>
							<label><b>Fecha</b></label>
							<input type="text" value={order.date} disabled />
						</div>
						<div>
							<label><b>Dirección del pedido</b></label>
							<input type="text" value={order.shipAddress} disabled />
						</div>
						<input type="submit" value="Eliminar"/>
					</form>
				</main>
			</>
		);

	}
}

export default DeleteOrderPage;
