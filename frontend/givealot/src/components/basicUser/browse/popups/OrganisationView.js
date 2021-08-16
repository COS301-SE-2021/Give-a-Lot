import React from "react";
/* 
    set to false or true to indicate that the popup was opened from
    either the browse results or the search interface
*/
export var pop_up_location_controller = false;

export function assignNewValue(newValue) {
    pop_up_location_controller = newValue;
}


export function popupOrganisationClose(wasOpenedFromSearch) {
    if (pop_up_location_controller === true) {
        document.getElementsByClassName('search-container')[0].setAttribute('style', 'display:block');

        /* 
            set it back to false otherwise 
            the search results will always display block
        */
        assignNewValue(false);
    }


    let overlay_tmp = document.getElementsByClassName('overlay')[0];
    let orgName = document.getElementsByClassName('popup-orgTitle')[0];
    let orgDescription = document.getElementsByClassName('popup-orgDescription')[0];
    let orgSector = document.getElementsByClassName('quick-sector')[0];
    let orgFounder = document.getElementsByClassName('quick-founder')[0];
    let orgDateFounded = document.getElementsByClassName('quick-date')[0];
    let orgAddress = document.getElementsByClassName('quick-address')[0];

    overlay_tmp.setAttribute("style", "display:none");
    orgName.innerText = "loading...";
    orgDescription.innerText = "";
    orgSector.innerText = "";
    orgFounder.innerText = "";
    orgDateFounded.innerText = "";
    orgAddress.innerText = "";
}


export function popupOrganisation(orgId) {
    let overlay_tmp = document.getElementsByClassName('overlay')[0];
    let orgName = document.getElementsByClassName('popup-orgTitle')[0];
    let orgDescription = document.getElementsByClassName('popup-orgDescription')[0];
    let orgSector = document.getElementsByClassName('quick-sector')[0];
    let orgFounder = document.getElementsByClassName('quick-founder')[0];
    let orgDateFounded = document.getElementsByClassName('quick-date')[0];
    let orgAddress = document.getElementsByClassName('quick-address')[0];

    /*make the overlay visible*/
    overlay_tmp.setAttribute("style", "display:block");
    orgName.innerText = "The church of the saints and the petrol 2";
    orgDescription.innerText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor\n" +
        "                                incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\n" +
        "                                exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute\n" +
        "                                irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat\n" +
        "                                nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa\n" +
        "                                qui officia deserunt mollit anim id est laborum.";
    orgSector.innerText = "children";
    orgFounder.innerText = "KidsNextDoor";
    orgDateFounded.innerText = "12 Dec 2019";
    orgAddress.innerText = "18 Beauty Str. Jhb , 1809";
}


function organisationView() {
    return (
        <div className="overlay">
            <div className="overlay2" onClick={(e) => popupOrganisationClose(pop_up_location_controller)}>

            </div>
            <div className="popup-container">
                <button className='popup-closeBTN' onClick={(e) => popupOrganisationClose(pop_up_location_controller)}>x</button>
                <div className="section-1">
                    <p className="popup-orgTitle"></p>
                    <p className="popup-orgDescription">
                    </p>
                    <button>continue reading</button>
                </div>
                <div className="popup-donation-section">
                    <p>Help organizations continue to do the good that they do. donate today</p>
                    <button>Donate</button>
                </div>

                <div className="pop-up-quick-facts">
                    <p>Quick facts</p>
                    <table>
                        <tbody>
                            <tr><td className="popup-table-main-title">sector</td><td><span className="quick-sector"></span></td></tr>
                            <tr><td className="popup-table-main-title">founder</td><td><span className="quick-founder"></span></td></tr>
                            <tr><td className="popup-table-main-title"> Date founded</td><td><span className="quick-date"></span></td></tr>
                            <tr><td className="popup-table-main-title">Date founded</td><td><span className="quick-address"></span></td></tr>
                        </tbody>
                    </table>
                </div>

                <div className="popup-report-certificate-btns-container">
                    <button className="popup-report-btn">Report</button>
                    <button className="popup-certificate-btn">Certificate</button>
                </div>

            </div>
        </div>
    );
}

export default organisationView;