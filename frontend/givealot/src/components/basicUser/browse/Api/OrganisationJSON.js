//import react from 'react';
/* 
    send a post
    request to the server to 
    get organisations from the database
*/

export function getOranisations ()
{
    /* 
        this function sends the request
        and returns the response object
     */
    let jsonData = [
        {
            sector : "hellowers",
            organisations : [
                {
                    orgId: "1",
                    name: "looters association trust",
                    dateAdded : "10 Dec 2020",
                    imgUrl : "./images_tmp/3.jpg"
                },
                {
                    orgId: "2",
                    name: "looters principle",
                    dateAdded : "11 Dec 2020",
                    imgUrl : "./images_tmp/9.jpg"
                },
                {
                    orgId: "3",
                    name: "we loot, we rest",
                    dateAdded : "11 Dec 2020",
                    imgUrl : "./images_tmp/10.jpg"
                }
                ,
                {
                    orgId: "4",
                    name: "we loot, we rest",
                    dateAdded : "11 Dec 2020",
                    imgUrl : "./images_tmp/11.jpg"
                }
                ,
                {
                    orgId: "5",
                    name: "we loot, we rest",
                    dateAdded : "11 Dec 2020",
                    imgUrl : "./images_tmp/12.jpg"
                }
                ,
                {
                    orgId: "6",
                    name: "we loot, we rest",
                    dateAdded : "11 Dec 2020",
                    imgUrl : "./images_tmp/13.jpg"
                }
            ]
        },
        {
        sector : "children",
        organisations : [
            {
                orgId: "7",
                name: "org1_chilren",
                dateAdded : "10 Dec 2020",
                imgUrl : "./images_tmp/14.jpg"
            },
            {
                orgId: "8",
                name: "org2_chilren",
                dateAdded : "11 Dec 2020",
                imgUrl : "./images_tmp/15.jpg"
            }
            ,
            {
                orgId: "9",
                name: "org6_chilren",
                dateAdded : "11 Dec 2020",
                imgUrl : "./images_tmp/16.jpg"
            }
            ,
            {
                orgId: "10",
                name: "org6_chilren",
                dateAdded : "11 Dec 2020",
                imgUrl : "./images_tmp/17.jpg"
            }
            ,
            {
                orgId: "11",
                name: "org6_chilren",
                dateAdded : "11 Dec 2020",
                imgUrl : "./images_tmp/18.jpg"
            }
        ]
    },
    {
        sector : "youth",
        organisations : [
            {
                orgId: "12",
                name: "org3_chilren",
                dateAdded : "10 Dec 2020",
                imgUrl : "./images_tmp/19.jpg"
            },
            {
                orgId: "13",
                name: "org4_chilren",
                dateAdded : "11 Dec 2020",
                imgUrl : "./images_tmp/20.jpg"
            },
            {
                orgId: "14",
                name: "org5_chilren",
                dateAdded : "11 Dec 2020",
                imgUrl : "./images_tmp/9.jpg"
            }
        ]
    },
    {
        sector : "looters",
        organisations : [
            {
                orgId: "15",
                name: "looters association trust",
                dateAdded : "10 Dec 2020",
                imgUrl : "./images_tmp/21.jpg"
            },
            {
                orgId: "16",
                name: "looters principle",
                dateAdded : "11 Dec 2020",
                imgUrl : "./images_tmp/22.jpg"
            },
            {
                orgId: "17",
                name: "we loot, we rest",
                dateAdded : "11 Dec 2020",
                imgUrl : "./images_tmp/23.jpg"
            }
            ,
            {
                orgId: "18",
                name: "we loot, we rest",
                dateAdded : "11 Dec 2020",
                imgUrl : "./images_tmp/24.jpg"
            }
            ,
            {
                orgId: "19",
                name: "we loot, we rest",
                dateAdded : "11 Dec 2020",
                imgUrl : "./images_tmp/25.jpg"
            }
            ,
            {
                orgId: "20",
                name: "we loot, we rest",
                dateAdded : "11 Dec 2020",
                imgUrl : "./images_tmp/3.jpg"
            }
        ]
    }

];
 return jsonData;
}
 