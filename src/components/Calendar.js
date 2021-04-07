import React from 'react';
import {Link} from 'react-router-dom';
const Calendar = () =>
{
    return (
        <div className="d-flex flex-column" id="content-wrapper">
        <div id="content">
          <nav className="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
            <div className="container-fluid"><button className="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop" type="button"><i className="fas fa-bars" /></button>
              <ul className="navbar-nav flex-nowrap ml-auto">
                <div className="d-none d-sm-block topbar-divider" />
                <li className="nav-item dropdown no-arrow">
                  <div className="nav-item dropdown no-arrow"><a className="dropdown-toggle nav-link" aria-expanded="false" data-toggle="dropdown" href="#"><span className="d-none d-lg-inline mr-2 text-gray-600 small">Riley Durbin</span><img className="border rounded-circle img-profile" src="assets/img/avatars/Riley-headshot.jpg" /></a>
                    <div className="dropdown-menu shadow dropdown-menu-right animated--grow-in">
                    <Link className="dropdown-item" to="/profile">
                      <i className="fas fa-user fa-sm fa-fw mr-2 text-gray-400" />&nbsp;Profile</Link>
                      <a className="dropdown-item" href="#">
                        <i className="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400" />&nbsp;Settings</a>
                      <div className="dropdown-divider" />
                      <a className="dropdown-item" href="#">
                        <i className="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400" />&nbsp;Logout</a>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </nav>
          <div className="container" style={{marginBottom: '20px'}}>
            <div className="row">
              <div className="col-md-12 text-center d-xl-flex justify-content-xl-center">
                <h3 style={{color: 'var(--dark)'}}>Request SuperFrog at Your Event</h3>
              </div>
            </div>
            <div className="row">
              <div className="col-md-12 text-center d-xl-flex justify-content-xl-center" style={{marginBottom: '10px'}}><a className="btn btn-primary" role="button" style={{background: 'var(--purple)'}} href="request.html">Request</a></div>
            </div>
          </div>
          <div id="calendar" />
        </div>
        <footer className="bg-white sticky-footer">
          <div className="container my-auto">
            <div className="text-center my-auto copyright"><span>Copyright © Brand 2021</span></div>
          </div>
        </footer>
      </div>
    )  
}

export default Calendar