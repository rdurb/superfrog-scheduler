import React from 'react';
import {Calendar, Dashboard, Home, Login, Navbar, Profile, Register, Request, SpiritDirectorTable, Tcuevent, TopNav} from './components';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';


function App() {
  return (
    <Router>
          <div id="wrapper" style={{color: 'var(--purple)'}}>
            <Navbar />
            {/* <TopNav /> */}
            <Route exact path ='/' component={Home}/>
            <Route exact path ='/calendar' component={Calendar}/>
            <Route exact path ='/dashboard' component={Dashboard}/>
            <Route exact path ='/login' component={Login}/>
            <Route exact path ='/profile' component={Profile}/>
            <Route exact path ='/register' component={Register}/>
            <Route exact path ='/request' component={Request}/>
            <Route exact path ='/SpiritDirectorTable' component={SpiritDirectorTable}/>
            <Route exact path ='/tcuevent' component={Tcuevent}/>
            {/* <a className="border rounded d-inline scroll-to-top" href="#page-top"><i className="fas fa-angle-up" /></a> */}
        </div>
    </Router>
  );
}

export default App;
