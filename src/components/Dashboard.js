import React from 'react';
import {Link} from 'react-router-dom';
const Dashboard = () =>
{
    return (
        <div className="d-flex flex-column" id="content-wrapper">
        <div id="content">
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
                    <div className="dropdown-menu text-success shadow dropdown-menu-right animated--grow-in">
                    <Link className="dropdown-item" to="/profile">
                      <i className="fas fa-user fa-sm fa-fw mr-2 text-gray-400" />&nbsp;Profile</Link>
                      <a className="dropdown-item" href="#"><i className="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400" />&nbsp;Settings</a>
                      <a className="dropdown-item" href="#"><i className="fas fa-list fa-sm fa-fw mr-2 text-gray-400" />&nbsp;Activity log</a>
                      <div className="dropdown-divider" /><a className="dropdown-item" href="#"><i className="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400" />&nbsp;Logout</a>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </nav>
          <div className="container-fluid">
            <div className="d-sm-flex justify-content-between align-items-center mb-4">
              <h3 className="text-dark mb-0">Student Performance Dashboard</h3>
            </div>
            <div className="row" data-toggle="tooltip" data-bss-tooltip title="Course Enrollment">
              <div className="col-lg-6 mb-4">
                <div className="card shadow mb-4">
                  <div className="card-header py-3">
                    <h6 className="text-primary font-weight-bold m-0">Projects</h6>
                  </div>
                  <div className="card-body">
                    <h4 className="small font-weight-bold">Lab 4 - Web Tech&nbsp;<span className="float-right">20%</span></h4>
                    <div className="progress mb-4">
                      <div className="progress-bar bg-danger" aria-valuenow={20} aria-valuemin={0} aria-valuemax={100} style={{width: '20%'}}><span className="sr-only">20%</span></div>
                    </div>
                    <h4 className="small font-weight-bold">Lab 3 - Operating System<span className="float-right">40%</span></h4>
                    <div className="progress mb-4">
                      <div className="progress-bar bg-warning" aria-valuenow={40} aria-valuemin={0} aria-valuemax={100} style={{width: '40%'}}><span className="sr-only">40%</span></div>
                    </div>
                    <h4 className="small font-weight-bold">Database Lab<span className="float-right">60%</span></h4>
                    <div className="progress mb-4">
                      <div className="progress-bar bg-primary" aria-valuenow={60} aria-valuemin={0} aria-valuemax={100} style={{width: '60%'}}><span className="sr-only">60%</span></div>
                    </div>
                    <h4 className="small font-weight-bold"><strong>Self project - AI&nbsp;Reversi Game</strong><span className="float-right">80%</span></h4>
                    <div className="progress mb-4">
                      <div className="progress-bar bg-info" aria-valuenow={80} aria-valuemin={0} aria-valuemax={100} style={{width: '80%'}}><span className="sr-only">80%</span></div>
                    </div>
                    <h4 className="small font-weight-bold"><strong>Lab 4 -&nbsp;Geology</strong><span className="float-right">Complete!</span></h4>
                    <div className="progress mb-4">
                      <div className="progress-bar bg-success" aria-valuenow={100} aria-valuemin={0} aria-valuemax={100} style={{width: '100%'}}><span className="sr-only">100%</span></div>
                    </div>
                  </div>
                </div>
                <div className="card shadow mb-4">
                  <div className="card-header py-3">
                    <h6 className="text-primary font-weight-bold m-0">Todo List</h6>
                  </div>
                  <ul className="list-group list-group-flush">
                    <li className="list-group-item">
                      <div className="row align-items-center no-gutters">
                        <div className="col mr-2">
                          <h6 className="mb-0"><strong>Team meeting</strong></h6><span className="text-xs">10:30 AM</span>
                        </div>
                        <div className="col-auto">
                          <div className="custom-control custom-checkbox"><input className="custom-control-input" type="checkbox" id="formCheck-1" /><label className="custom-control-label" htmlFor="formCheck-1" /></div>
                        </div>
                      </div>
                    </li>
                    <li className="list-group-item">
                      <div className="row align-items-center no-gutters">
                        <div className="col mr-2">
                          <h6 className="mb-0"><strong>Do OS Lab</strong></h6><span className="text-xs">11:30 AM</span>
                        </div>
                        <div className="col-auto">
                          <div className="custom-control custom-checkbox"><input className="custom-control-input" type="checkbox" id="formCheck-2" /><label className="custom-control-label" htmlFor="formCheck-2" /></div>
                        </div>
                      </div>
                    </li>
                    <li className="list-group-item">
                      <div className="row align-items-center no-gutters">
                        <div className="col mr-2">
                          <h6 className="mb-0"><strong>Do Database Lab</strong></h6><span className="text-xs">12:30 AM</span>
                        </div>
                        <div className="col-auto">
                          <div className="custom-control custom-checkbox"><input className="custom-control-input" type="checkbox" id="formCheck-3" /><label className="custom-control-label" htmlFor="formCheck-3" /></div>
                        </div>
                      </div>
                    </li>
                  </ul>
                </div>
              </div>
              <div className="col-lg-6">
                <div className="chart-area"><canvas data-bss-chart="{&quot;type&quot;:&quot;pie&quot;,&quot;data&quot;:{&quot;labels&quot;:[&quot;Arts&quot;,&quot;Social Work&quot;,&quot;Design&quot;,&quot;Business&quot;,&quot;Math&quot;,&quot;Computer Science&quot;],&quot;datasets&quot;:[{&quot;label&quot;:&quot;&quot;,&quot;backgroundColor&quot;:[&quot;#4e73df&quot;,&quot;#1cc88a&quot;,&quot;#36b9cc&quot;,&quot;rgb(211,24,204)&quot;,&quot;rgb(213,187,55)&quot;,&quot;rgb(82,9,9)&quot;],&quot;borderColor&quot;:[&quot;#ffffff&quot;,&quot;#ffffff&quot;,&quot;#ffffff&quot;,&quot;#ffffff&quot;,&quot;#ffffff&quot;,&quot;#ffffff&quot;],&quot;data&quot;:[&quot;50&quot;,&quot;30&quot;,&quot;15&quot;,&quot;20&quot;,&quot;15&quot;,&quot;40&quot;]}]},&quot;options&quot;:{&quot;maintainAspectRatio&quot;:false,&quot;legend&quot;:{&quot;display&quot;:true,&quot;reverse&quot;:false},&quot;title&quot;:{&quot;display&quot;:true,&quot;text&quot;:&quot;Enrollment by course&quot;}}}" /></div>
              </div>
            </div>
          </div>
        </div>
        <footer className="bg-white sticky-footer">
          <div className="container my-auto">
            <div className="text-center my-auto copyright"><span>Copyright © Brand 2021</span></div>
          </div>
        </footer>
      </div>
    )  
}

export default Dashboard