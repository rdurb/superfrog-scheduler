import React from 'react';
import {Link} from 'react-router-dom';
const Request = () =>
{
    return (
      <div className="d-flex flex-column" id="content-wrapper">
      <div id="content">
        <nav className="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
          <div className="container-fluid"><button className="btn btn-link d-md-none rounded-circle mr-3" id="sidebarToggleTop" type="button"><i className="fas fa-bars" /></button>
            <ul className="navbar-nav flex-nowrap ml-auto">
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
        <section className="contact-clean" style={{marginBottom: '15px'}}>
          <form method="post">
            <h2 className="text-center" style={{marginBottom: '5px'}}>Event Request Form</h2>
            <h5 className="text-center" style={{color: 'var(--gray)', marginBottom: '25px'}}>Please fill all the information accurately<br /></h5>
            <div className="form-group"><input className="form-control" type="text" name="name" placeholder="Name" /></div>
            <div className="form-group"><input className="form-control is-invalid" type="email" name="email" placeholder="Email" style={{paddingRight: '12px', marginBottom: '15px'}} /><input className="form-control" type="tel" name="tel" placeholder="Phone" style={{marginBottom: '15px'}} /><input className="form-control" type="text" name="event-title" placeholder="Event Title" style={{marginBottom: '15px'}} /><textarea className="form-control" placeholder="Event Description" style={{marginBottom: '15px'}} name="event-description" defaultValue={""} /><label style={{marginBottom: '0px'}}>Event Date</label><input className="form-control" type="date" style={{marginBottom: '15px'}} name="event-date" /><label style={{marginBottom: '0px'}}>Start Time</label><input className="form-control" type="time" style={{marginBottom: '15px'}} name="event-start-time" /><label style={{marginBottom: '0px'}}>End Time</label><input className="form-control" type="time" name="event-end-time" /><small className="form-text text-danger">Please enter a correct email address.</small></div>
            <div className="form-group d-xl-flex justify-content-xl-center"><button className="btn btn-primary" type="submit" style={{background: 'var(--purple) !important', marginTop: '0px'}}>send </button></div>
          </form>
        </section>
      </div>
      <footer className="bg-white sticky-footer">
        <div className="container my-auto">
          <div className="text-center my-auto copyright"><span>Copyright © Brand 2021</span></div>
        </div>
      </footer>
    </div>
    )  
}

export default Request