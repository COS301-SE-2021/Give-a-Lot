// import React from 'react';
// import Enzyme, { shallow, mount } from 'enzyme'
// import { MemoryRouter
// } from 'react-router'
// import Adapter from '@wojtekmaj/enzyme-adapter-react-17'
// import { Route } from 'react-router-dom';
// import SidebarRows from './components/Admin/SidebarRows';
// import AdminOrgs from './components/Admin/AdminOrgs';
// import AdminUsers from './components/Admin/AdminUsers';
// import AdminCerts from './components/Admin/AdminCerts';

// Enzyme.configure({adapter: new Adapter( )});

// let pathMap = {};
// describe('routes using array of routers', () => {
//   beforeAll(() => {
//     const component = shallow(<SidebarRows/>);
//     pathMap = component.find(Route).reduce((pathMap, route) => {
//         const routeProps = route.props();
//         pathMap[routeProps.path] = routeProps.component;
//         return pathMap;
//       }, {});
//       console.log(pathMap)
//   })
//   it('should show AdminOrgs component for /adminorgs router (getting array of routes)', () => {
//     // console.log(pathMap['/adminorgs']);
//     expect(pathMap['/adminorgs']).toBe(AdminOrgs);
//   })

// })

// import { shallow } from 'enzyme';
import { Route } from 'react-router';
// import Routes from './Routes.jsx';
import Admin from './components/Admin/Admin';
import AdminOrgs from './components/Admin/AdminOrgs';
import Enzyme, { shallow, mount } from 'enzyme';
 import { MemoryRouter
 } from 'react-router';
 import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
 import AdminCerts from './components/Admin/AdminCerts';
import AdminUsers from './components/Admin/AdminUsers';
import Dashboard from "./components/Admin/Dashboard";

 Enzyme.configure({adapter: new Adapter( )});

it('renders correct Admin organisation route', () => {
  const wrapper = shallow(<Admin />);
  const pathMap = wrapper.find(Route).reduce((pathMap, route) => {
    const routeProps = route.props();
    pathMap[routeProps.path] = routeProps.component;
    return pathMap;
  }, {});
  // { '/adminorgs' : AdminOrgs, ... }

  expect(pathMap['/adminorgs']).toBe(AdminOrgs);

});

it('renders correct Admin Users route', () => {
  const wrapper = shallow(<Admin />);
  const pathMap = wrapper.find(Route).reduce((pathMap, route) => {
    const routeProps = route.props();
    pathMap[routeProps.path] = routeProps.component;
    return pathMap;
  }, {});
  // { '/adminorgs' : AdminOrgs, ... }

  expect(pathMap['/adminusers']).toBe(AdminUsers);

});

it('renders correct Admin Certificates route', () => {
  const wrapper = shallow(<Admin />);
  const pathMap = wrapper.find(Route).reduce((pathMap, route) => {
    const routeProps = route.props();
    pathMap[routeProps.path] = routeProps.component;
    return pathMap;
  }, {});
  // { '/adminorgs' : AdminOrgs, ... }

  expect(pathMap['/admincerts']).toBe(AdminCerts);

});

it('renders correct Admin Dashboard route', () => {
  const wrapper = shallow(<Admin />);
  const pathMap = wrapper.find(Route).reduce((pathMap, route) => {
    const routeProps = route.props();
    pathMap[routeProps.path] = routeProps.component;
    return pathMap;
  }, {});
  // { '/adminorgs' : AdminOrgs, ... }

  expect(pathMap['/']).toBe(Dashboard);

});

it('should fail', () => {
  const wrapper = shallow(<Admin />);
  const pathMap = wrapper.find(Route).reduce((pathMap, route) => {
    const routeProps = route.props();
    pathMap[routeProps.path] = routeProps.component;
    return pathMap;
  }, {});
  // { '/adminorgs' : AdminOrgs, ... }

  expect(pathMap['/dashboard']).toBe(Dashboard);

});

it('Should fail', () => {
  const wrapper = shallow(<Admin />);
  const pathMap = wrapper.find(Route).reduce((pathMap, route) => {
    const routeProps = route.props();
    pathMap[routeProps.path] = routeProps.component;
    return pathMap;
  }, {});
  // { '/adminorgs' : AdminOrgs, ... }

  expect(pathMap['/admin']).toBe(Dashboard);

});


