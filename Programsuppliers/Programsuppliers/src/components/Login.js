import React, { useState, useEffect } from 'react';
import Swal from 'sweetalert2';
import md5 from 'md5';
import Cookies from 'universal-cookie';
import logo from '../logo.svg';

const cookies = new Cookies();

function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  useEffect(() => {
    if (cookies.get('email')) {
      window.location.href = "./supplier";
    }
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    if (email === '' || password === '') {
      Swal.fire({
        title: 'Error!',
        text: 'Todos los campos son obligatorios',
        icon: 'error',
        confirmButtonText: 'Aceptar'
      });

      return;
    }

    if (email === 'admin@prueba.test' && md5(password) === md5('12345')) {
      cookies.set('email', email, { path: "/" });

      window.location.href = "./supplier";
    } else {
      Swal.fire({
        title: 'Error!',
        text: 'Correo o contraceña incorrectos',
        icon: 'error',
        confirmButtonText: 'Aceptar'
      });

      return;
    }
  }

  return (
    <div className='login template d-flex justify-content-center align-items-center w-100 vh-100'>
      <div className='form_container_login card p-4 bg-white shadow bg-body-tertiary rounded'>
        <form onSubmit={handleSubmit}>
          <div class="text-center">
            <img src={logo} alt="BootstrapBrain Logo" width="150" height="150"></img>
          </div>

          <h1 className='fs-3 fw-normal text-center text-secondary'>Iniciar Sesión</h1>

          <div className='mb-3'>
            <label htmlFor='email' className="form-label">Correo electronico</label>
            <input type='email' id='email' name='email' value={email} onChange={e => setEmail(e.target.value)}
              className='form-control' placeholder='Ingrese su correo electronico' autoComplete='email'></input>
          </div>

          <div className='mb-3'>
            <label htmlFor='password' className="form-label">Contraseña</label>
            <input type='password' id='password' name='password' value={password} onChange={e => setPassword(e.target.value)}
              className='form-control' placeholder='Ingrese su contraseña' autoComplete='current-password'></input>
          </div>

          <div className='d-grid'>
            <button className='btn btn-secondary'>Ingresar</button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;