import React, { useState } from 'react'
import { login } from '../functions/funciones'

function Login() {
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [error, setError] = useState(false)

    const handleSubmit = (e) => {
        e.preventDefault()
        if (email === "" | password === "") {
            setError(true)
            return
        }
        setError(false)
        login(email, password)

    }

    return (
        <section>
            <h1>Login</h1>
            <form
                onSubmit={handleSubmit}
            >
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
                <button>Iniciar</button>
            </form>
            {error && <p>Todos los campos son obligatorios</p>}
        </section>
    )
}

export default Login