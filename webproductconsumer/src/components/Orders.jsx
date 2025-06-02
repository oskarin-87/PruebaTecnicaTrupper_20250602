import React, { useEffect, useState } from 'react'
import { getAll } from '../functions/funciones'

const Orders = () => {
    const [orders, setOrders] = useState(null)

    useEffect(() => {
        getAll(setOrders)
    }, [])

    return (
        
        <>
            <br/>
            <h2>Orders List</h2>
            {orders != null ? 
            orders.map(order => (
                <p key={order.id}> 
                    ID: {order.id}&nbsp;&nbsp;&nbsp;
                    Sucursal Id: {order.subsidiaryId}&nbsp;&nbsp;&nbsp;
                    Fecha: {order.date}&nbsp;&nbsp;&nbsp;
                    Total: {order.total}&nbsp;&nbsp;&nbsp;
                </p>
                
            )) : ('There are no orders.')}

        </>
    )
}

export default Orders