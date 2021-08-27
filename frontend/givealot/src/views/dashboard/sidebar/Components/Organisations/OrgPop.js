import React from "react";
import "../../styles/Organisations.css"

export default ({ close }) => (
    <div className="modalPop">
        <a className="close" onClick={close}>
            &times;
        </a>
        <div className="headerPop"> Modal Title </div>
        <div className="contentPop">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Atque, a nostrum.
            Dolorem, repellat quidem ut, minima sint vel eveniet quibusdam voluptates
            delectus doloremque, explicabo tempore dicta adipisci fugit amet
            dignissimos?

        </div>
    </div>
);
