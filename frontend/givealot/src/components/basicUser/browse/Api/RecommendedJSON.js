
/*
    send a post
    request to the server to
    get organisations from the database
*/

export function getRecommendedOrganisations ()
{
    let jsonData = [
        {
            orgId: "org_id_rec_1",
            name: "rec organisation name 1",
            sector:"rec sector here",
            imgUrl: "./images_tmp/1.jpg",
            isVerified: true
        },
        {
            orgId: "org_id_rec_2",
            name: "rec organisation name 2",
            sector:"rec sector here",
            imgUrl: "./images_tmp/2.jpg",
            isVerified: true
        },
        {
            orgId: "org_id_rec_3",
            name: "rec organisation name 3",
            sector:"rec sector here",
            imgUrl: "./images_tmp/4.jpg",
            isVerified: true
        }
        ,
        {
            orgId: "org_id_rec_4",
            name: "rec organisation name 3",
            sector:"rec sector here",
            imgUrl: "./images_tmp/7.jpg",
            isVerified: true
        }
        ,
        {
            orgId: "org_id_rec_5",
            name: "rec organisation name 3",
            sector:"rec sector here",
            imgUrl: "./images_tmp/6.jpg",
            isVerified: true
        }
    ];

    return jsonData;
}
