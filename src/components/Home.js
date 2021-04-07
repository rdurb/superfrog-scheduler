import React from 'react';
import {Link} from 'react-router-dom';
const Home = () =>
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
            <section className="features-boxed" style={{background: 'var(--fc-list-event-hover-bg-color)'}}>
              <div className="container" style={{color: 'var(--purple)', background: 'var(--fc-list-event-hover-bg-color)'}}>
                <div className="intro">
                  <h2 className="text-center">SuperFrog Scheduler</h2>
                </div>
                <div className="row justify-content-center features">
                  <div className="col-sm-6 col-md-5 col-lg-4 item">
                    <div className="box" style={{height: '470px'}}><i className="fa fa-money icon" style={{color: 'var(--purple)', borderColor: 'var(--purple)'}} />
                      <h3 className="name" style={{borderColor: 'var(--purple)'}}>Pricing</h3>
                      <p className="description">ALL appearances are paid. Prices are based on a 1 hour appearance; additional fees may apply if more than one hour. SuperFrog, Showgirls, and Cheerleaders are individually priced. Payment must be made after receiving
                        an appearance request approval email, and a minimum of 24 hours prior to the event or it will be canceled. <br /></p>
                    </div>
                  </div>
                  <div className="col-sm-6 col-md-5 col-lg-4 item">
                    <div className="box" style={{height: '470px'}}><i className="fa fa-map-marker icon" style={{color: 'var(--purple)'}} />
                      <h3 className="name" style={{borderColor: 'var(--purple)'}}>Range</h3>
                      <p className="description">We only service requests that are within 100 mile radius from Amon G. Carter Stadium.<br /></p>
                    </div>
                  </div>
                  <div className="col-sm-6 col-md-5 col-lg-4 item">
                    <div className="box" style={{height: '470px'}}><i className="fa fa-calendar icon" style={{color: 'var(--purple)'}} />
                      <h3 className="name" style={{borderColor: 'var(--purple)'}}>Request</h3>
                      <p className="description">Request TCU Spirit from a calendar of available dates. Requests must be submitted at least 14 days prior to event date to be considered. Submission of a request does not guarantee the event will be accepted. TCU Spirit
                        has until 5 days prior the date of the event to accept or decline a request.<br /></p>
                    </div>
                  </div>
                </div>
              </div>
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

export default Home