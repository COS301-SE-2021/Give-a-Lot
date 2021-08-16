import React from 'react';
import RegisterUser from "./RegisterUser";

export const FormError = ({formErrors}) =>
    <div className='FormError'>
        {Object.keys(formErrors).map((fieldName, i) => {
            if(formErrors[fieldName].length > 0){
                return (
                    <p key={i}>{fieldName} {formErrors[fieldName]}</p>
                )
            } else {
                return '';
            }
        })}
    </div>

export default FormError