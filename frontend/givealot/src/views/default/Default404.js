function Default404()
{
    if (localStorage.getItem("role")){
        if (localStorage.getItem("role") === "admin" || localStorage.getItem("role") === "organisation"){
            window.location.href = "http://c294-102-250-7-72.ngrok.io/dashboard/"
        }
    }
    return (
    <div>
        404
    </div>
    )
}

export default Default404;

