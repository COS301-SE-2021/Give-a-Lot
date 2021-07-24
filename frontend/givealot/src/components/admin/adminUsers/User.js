// import React from 'react';
// import { List, Datagrid, TextField } from 'admin-on-rest';

// export class User extends Component {

//     render() {
//         return (
//             <List {...props}>
//                 <Datagrid>
//                     <TextField source="id" />
//                     <TextField source="title" />
//                     <TextField source="body" />
//                 </Datagrid>
//             </List>
//         );
//     }

// export default User

import React from 'react'
import { List, Datagrid, TextField, EmailField } from 'admin-on-rest';
// import User  from './User';

export default function User(props) {

    
        return (
            // <div className="adminUsers" >
            //     here is the users
            // </div>
            <List title="All users" {...props} style={{width: "100%"}}>
                <Datagrid style={{width: "1000px"}}>
                    <TextField source="id" />
                    <TextField source="name" />
                    <TextField source="username" />
                    <EmailField source="email" />
                </Datagrid>
            </List>
        )

}

// export default User

