import { useState, useEffect } from 'react';
import * as network from '../Network.js';
import * as stack from "../Stack.js";

function DeleteCategoryPage(props) {

    const category = props.category;

    const [error, setError] = useState(null);
    

    function onClickGoBack(ev) {
        stack.goBack();
    }

    async function handleSubmit(ev) {
        ev.preventDefault();
        try {
            await network.deleteCategory(category.id);
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
                <header><h1>Eliminando categoría</h1></header>
                <main>
                    <form onSubmit={handleSubmit}>
                        <div>
                            <label><b>Id</b></label>
                            <input type="text" value={category.id} disabled/>
                        </div>
                        <div>
                            <label><b>Nombre</b></label>
                            <input type="text" value={category.name} disabled/>
                        </div>
                        <div>
                            <label><b>Descripción</b></label>
                            <input type="text" value={category.description} disabled/>
                        </div>
						<input type="submit" value="Eliminar"/>
                    </form>
                </main>
            </>
        );

    }
}

export default DeleteCategoryPage;
