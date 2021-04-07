import React from 'react';
import {Link} from 'react-router-dom';
const Navbar = () =>
{
    return (
      // <div id="wrapper" style={{color: 'var(--purple)'}}>
      <nav className="navbar navbar-dark align-items-start visible sidebar sidebar-dark accordion bg-gradient-primary p-0" id="nav-bar" style={{background: 'var(--purple)'}}>
        <div className="container-fluid d-flex flex-column p-0">
          <a className="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" to="#">
            <div className="sidebar-brand-icon"><i className="fas fa-frog" /></div>
          </a>
          <hr className="sidebar-divider my-0" />
          <ul className="navbar-nav text-light" id="accordionSidebar">
            <li className="nav-item"><Link className="nav-link active" to="/"><i className="fa fa-home" /><span>Home</span></Link></li>
            <li className="nav-item"><Link className="nav-link" to="/calendar"><i className="fa fa-calendar" /><span>Calendar</span></Link></li>
            <li className="nav-item"><Link className="nav-link" to="/SpiritDirectorTable"><i className="fas fa-table" /><span>Table</span></Link></li>
            <li className="nav-item"><Link className="nav-link" to="/login"><i className="far fa-user-circle" /><span>Login</span></Link></li>
            <li className="nav-item"><Link className="nav-link" to="/register"><i className="fas fa-user-circle" /><span>Register</span></Link></li>
            <li className="nav-item"><Link className="nav-link" to="/dashboard"><i className="fas fa-tachometer-alt" /><span>Dashboard</span></Link></li>
            <li className="nav-item"><Link className="nav-link" to="/tcuevent"><i className="fas fa-window-maximize" /><span>TCU Events</span></Link></li>
            <li className="nav-item" />
          </ul>
          <div className="text-center d-none d-md-inline"><button className="btn rounded-circle border-0" id="sidebarToggle" type="button" /></div>
        </div>
      </nav>
    // </div>
    )  
}

export default Navbar