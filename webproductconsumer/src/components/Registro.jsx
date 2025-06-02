import React, { useState } from 'react'
import { signup } from '../functions/funciones'

export const Registro = () => {

    const [fullName, setFullName] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [error, setError] = useState(false)

    const handleSubmit = (e) => {
        e.preventDefault()
        if (fullName === "" || email === "" | password === "") {
            setError(true)
            return
        }
        setError(false)
        signup(fullName, email, password)
    }


    return (
        <section>
            <h1>Register</h1>
            <form
                onSubmit={handleSubmit}
            >
                <input
                    type="text"
                    placeholder="Full Name"
                    value={fullName}
                    onChange={e => setFullName(e.target.value)}
                    size="30"
                /><br></br>
                <input
                    type="text"
                    placeholder="Email"
                    value={email}
                    onChange={e => setEmail(e.target.value)}
                    size="30"
                /><br></br>
                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={e => setPassword(e.target.value)}
                    size="30"
                /><br></br>
                <button>Registrar</button>
            </form>
            {error && <p>Todos los campos son obligatorios</p>}
        </section>
    )
}



export default Registro