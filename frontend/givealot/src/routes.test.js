import React from 'react';
import { shallow, mount } from 'enzyme';
// import Routes, { Home, News, NoMatch } from './Routes';
import { MemoryRouter
} from 'react-router'
import { Route } from 'react-router-dom';
import Dashboard from './components/Admin/Dashboard';
import AdminOrgs from './components/Admin/AdminOrgs';
import AdminUsers from './components/Admin/AdminUsers';


let pathMap = {};
describe('routes using array of routers', () => {
  beforeAll(() => {
    const component = shallow(<Routes/>);
    pathMap = component.find(Route).reduce((pathMap, route) => {
        const routeProps = route.props();
        pathMap[routeProps.path] = routeProps.component;
        return pathMap;
      }, {});
      console.log(pathMap)
  })
  it('should show Dashboard component for / router (getting array of routes)', () => {

    expect(pathMap['/']).toBe(Dashboard);
  })
  it('should show AdminOrgs component for /adminorgs router', () => {
    expect(pathMap['/adminorgs']).toBe(AdminOrgs);
  })
  it('should show AdminUsers component techdomain for /adminusers router', () => {
    expect(pathMap['/adminusers']).toBe(AdminUsers);
  })
  it('should show No match component for route not defined', ()=>{
      expect(pathMap['undefined']).toBe(NoMatch);
  })
})