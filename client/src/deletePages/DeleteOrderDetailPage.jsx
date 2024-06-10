import { useState, useEffect } from 'react';
import * as network from '../Network.js';
import * as stack from "../Stack.js";

function DeleteOrderDetailPage(props) {

	const orderDetail = props.orderDetail;

	const [error, setError] = useState(null);

	function onClickGoBack(ev) {
		stack.goBack();
	}

	async function handleSubmit(ev) {
		ev.preventDefault();
		try {
			await network.deleteOrderDetail(orderDetail.id);
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
				<header><h1>Eliminando detalle de pedido</h1></header>
				<main>
					<form onSubmit={handleSubmit}>
						<div>
							<label><b>Id</b></label>
							<input type="text" value={orderDetail.id} disabled />
						</div>
						<div>
							<label><b>Id del pedido</b></label>
							<input type="text" value={orderDetail.orderId} disabled />
						</div>
						<div>
							<label><b>Producto</b></label>
							<input type="text" value={orderDetail.productName} disabled />
						</div>
						<div>
							<label><b>Cantidad</b></label>
							<input type="text" value={orderDetail.quantity} disabled />
						</div>
						<input type="submit" value="Eliminar"/>
					</form>
				</main>
			</>
		);

	}
}

export default DeleteOrderDetailPage;
