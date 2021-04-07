import React from 'react';
import {Link} from 'react-router-dom';
const SpiritDirectorTable = () =>
{
    return (
      <div className="d-flex flex-column" id="content-wrapper">
      <div id="content" style={{marginRight: '5px'}}>
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
        <div className="container-fluid">
          <h3 className="text-dark mb-4" style={{color: 'var(--purple)'}}>Current Customer Information</h3>
          <div className="card" style={{marginBottom: '10px'}}>
            <div className="card-body">
              <h4 className="card-title" style={{fontSize: '18px'}}>Add a new customer here:</h4>
              <form className="d-lg-flex justify-content-lg-center">
                <input className="form-control" id="id" type="text" placeholder="ID" style={{marginLeft: '5px'}} />
                <input className="form-control" id="name" type="text" placeholder="Name" style={{marginLeft: '5px'}} />
                <input className="form-control" id="tel" type="text" placeholder="Phone" style={{marginLeft: '5px'}} />
                <input className="form-control" id="email" type="text" placeholder="Email" style={{marginLeft: '5px'}} />
                <button id="btn_add" className="btn btn-primary" type="button" style={{marginLeft: '5px', background: 'rgb(68,180,50)'}}>Add</button>
              </form>
            </div>
          </div>
          <div className="card shadow">
            <div className="card-body">
              <div className="row">
                <div className="col-md-6 text-nowrap">
                  <div id="dataTable_length" className="dataTables_length" aria-controls="dataTable"><label>Show&nbsp;<select className="form-control form-control-sm custom-select custom-select-sm">
                        <option value={10} selected>10</option>
                        <option value={25}>25</option>
                        <option value={50}>50</option>
                        <option value={100}>100</option>
                      </select>&nbsp;</label></div>
                </div>
                <div className="col-md-6">
                  <div className="text-md-right dataTables_filter" id="dataTable_filter"><label><input type="search" className="form-control form-control-sm" aria-controls="dataTable" placeholder="Search" /></label></div>
                </div>
              </div>
              <div className="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
                <table className="table my-0" id="dataTable">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Phone</th>
                      <th>Email</th>
                      <th className="text-left">Operation</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>James Watson</td>
                      <td>123-456-7890</td>
                      <td>jameswatson@gmail.com</td>
                      <td className="text-center d-lg-flex justify-content-lg-center">
                        <button className="btn btn-primary" type="button" style={{marginLeft: '0px', marginRight: '5px'}}>Edit</button>
                        <button className="btn btn-primary" type="button" style={{marginRight: '5px', background: 'var(--red)'}} href="javascript:void(0);" onclick="delTr(this);">Delete</button>
                      </td>
                    </tr>
                    <tr>
                      <td>2</td>
                      <td>Emilia Harper</td>
                      <td>456-789-1230<br /></td>
                      <td>e.Harper@yahoo.com</td>
                      <td className="text-center d-lg-flex justify-content-lg-center">
                        <button className="btn btn-primary" type="button" style={{marginLeft: '0px', marginRight: '5px'}}>Edit</button>
                        <button className="btn btn-primary" type="button" style={{marginRight: '5px', background: 'var(--red)'}} href="javascript:void(0);" onclick="delTr(this);">Delete</button>
                      </td>
                    </tr>
                  </tbody>
                  <tfoot>
                    <tr>
                      <td><strong>ID</strong></td>
                      <td><strong>Name</strong></td>
                      <td><strong>Phone</strong></td>
                      <td><strong>Email</strong></td>
                      <td><strong>Operation</strong></td>
                    </tr>
                  </tfoot>
                </table>
              </div>
              <div className="row">
                <div className="col-md-6 align-self-center">
                  <p id="dataTable_info" className="dataTables_info" role="status" aria-live="polite">Showing 1 to 2 of 2</p>
                </div>
                <div className="col-md-6">
                  <nav className="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                    <ul className="pagination">
                      <li className="page-item disabled"><a className="page-link" href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                      <li className="page-item active"><a className="page-link" href="#">1</a></li>
                      <li className="page-item"><a className="page-link" href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
                    </ul>
                  </nav>
                </div>
              </div>
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

export default SpiritDirectorTable