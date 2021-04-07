import React from 'react';
import {Link} from 'react-router-dom';
const TopNav = () =>
{
    return (
      // <div id="wrapper" style={{color: 'var(--purple)'}}>
      <nav className="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
      <div className="container-fluid"><button className="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop" type="button"><i className="fas fa-bars" /></button>
        <ul className="navbar-nav flex-nowrap ml-auto">
          <li className="nav-item dropdown d-sm-none no-arrow"><a className="dropdown-toggle nav-link" aria-expanded="false" data-toggle="dropdown" href="#"><i className="fas fa-search" /></a>
            <div className="dropdown-menu dropdown-menu-right p-3 animated--grow-in" aria-labelledby="searchDropdown">
              <form className="form-inline mr-auto navbar-search w-100">
                <div className="input-group"><input className="bg-light form-control border-0 small" type="text" placeholder="Search for ..." />
                  <div className="input-group-append"><button className="btn btn-primary py-0" type="button"><i className="fas fa-search" /></button></div>
                </div>
              </form>
            </div>
          </li>
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
    // </div>
    )  
}

export default TopNav