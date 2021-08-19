//import react from 'react';
/* 
    send a post
    request to the server to 
    get organisations from the database
*/
const axios = require('axios');


export default {
    getData: () =>
    axios({
        'method':'GET',
        'url':'http://localhost:8080/v1/browse/sectors'
    })
} 


/* export function getOranisations ()
{

         let jsonData = [];

        axios.get('http://localhost:8080/v1/browse/sectors')
        .then((response) => {
          console.log("GET Response")
          console.log(response)
          if(response.data.message === "success")
          {
                jsonData = response.data.object;
                console.log(jsonData);
          }
          else alert("no organisations to show");
        })
        .catch(function (error) 
        {
          console.log("Error while fetching market updates");
        });  

        console.log("hello there expecting request");
      

     jsonData = [
                {
                    sector : "hellowers",
                    organisations : [
                        {
                            orgId: "1",
                            name: "The givers of hope",
                            dateAdded : "10 Dec 2020",
                            imgUrl : "./images_tmp/3.jpg"
                        },
                        {
                            orgId: "2",
                            name: "Marcia Kindle Joy",
                            dateAdded : "11 Mar 2014",
                            imgUrl : "./images_tmp/9.jpg"
                        },
                        {
                            orgId: "3",
                            name: "The white flag",
                            dateAdded : "15 Dec 2019",
                            imgUrl : "./images_tmp/10.jpg"
                        }
                        ,
                        {
                            orgId: "4",
                            name: "Peter Mackinnon youth training",
                            dateAdded : "31 Dec 2020",
                            imgUrl : "./images_tmp/11.jpg"
                        }
                        ,
                        {
                            orgId: "5",
                            name: "Kwande zonke izingane",
                            dateAdded : "11 Feb 2018",
                            imgUrl : "./images_tmp/12.jpg"
                        }
                        ,
                        {
                            orgId: "6",
                            name: "You can help",
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
} */
 