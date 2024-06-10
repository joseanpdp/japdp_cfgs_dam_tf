import { useState, useEffect } from 'react';
import * as network from '../Network.js';
import * as stack from "../Stack.js";

function DeleteCustomerPage(props) {

	const customer = props.customer;

	const [error, setError] = useState(null);

	function onClickGoBack(ev) {
		stack.goBack();
	}

	async function handleSubmit(ev) {
		ev.preventDefault();
		try {
			await network.deleteCustomer(customer.id);
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
				<header><h1>Eliminando cliente</h1></header>
				<main>
					<form onSubmit={handleSubmit}>
						<div>
							<label><b>Id</b></label>
							<input type="text" value={customer.id} disabled />
						</div>
						<div>
							<label><b>Nombre</b></label>
							<input type="text" value={`${customer.name} ${customer.surname}`} disabled />
						</div>
						<div>
							<label><b>Dirección</b></label>
							<input type="text" value={customer.address} disabled />
						</div>
						<input type="submit" value="Eliminar"/>
					</form>
				</main>
			</>
		);

	}
}

export default DeleteCustomerPage;
