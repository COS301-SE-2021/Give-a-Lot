import React from 'react';
// import RegisterUser from "./RegisterUser";

export const FormError = ({formErrors}) =>
    <div className='FormError'>
        {Object.keys(formErrors).map((fieldName, i) => {
            if(formErrors[fieldName].length > 0){
                return (
                    <div style={{color: "red", fontWeight: "large"}}>
                        <p key={i}>{fieldName} {formErrors[fieldName]}</p>
                    </div>

                )
            } else {
                return '';
            }
        })}
    </div>

export default FormError