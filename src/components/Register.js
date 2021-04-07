import React from 'react';
import {Link} from 'react-router-dom';
const Register = () =>
{
    return (
      <div className="container">
      <div className="card shadow-lg o-hidden border-0 my-5">
        <div className="card-body p-0">
          <div className="row">
            <div className="col-lg-5 d-none d-lg-flex justify-content-center"><img className="d-lg-flex" src="assets/img/superfrog/superfrog.jpg" /></div>
            <div className="col-lg-7">
              <div className="p-5">
                <div className="text-center">
                  <h4 className="text-dark mb-4">Create an Account!</h4>
                </div>
                <form className="user">
                  <div className="form-group row">
                    <div className="col-sm-6 mb-3 mb-sm-0"><input className="form-control form-control-user" type="text" id="exampleFirstName" placeholder="First Name" name="first_name" /></div>
                    <div className="col-sm-6"><input className="form-control form-control-user" type="text" id="exampleFirstName" placeholder="Last Name" name="last_name" /></div>
                  </div>
                  <div className="form-group"><input className="form-control form-control-user" type="email" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Email Address" name="email" /></div>
                  <div className="form-group row">
                    <div className="col-sm-6 mb-3 mb-sm-0"><input className="form-control form-control-user" type="password" id="examplePasswordInput" placeholder="Password" name="password" /></div>
                    <div className="col-sm-6"><input className="form-control form-control-user" type="password" id="exampleRepeatPasswordInput" placeholder="Repeat Password" name="password_repeat" /></div>
                  </div><button className="btn btn-primary btn-block text-white btn-user" type="submit" style={{background: 'var(--purple)'}}>Register Account</button>
                  <hr />
                </form>
                <div className="text-center"><a className="small" href="forgot-password.html">Forgot Password?</a></div>
                <div className="text-center"><a className="small" href="login.html">Already have an account? Login!</a></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    )  
}

export default Register