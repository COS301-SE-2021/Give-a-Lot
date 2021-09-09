import cert from '../../../assets/pdfTemplates/CertificateComplete.pdf';
import {PDFtoIMG} from "react-pdf-to-image";

function PDFCert()
{
    return(
    <div>
        <PDFtoIMG file={cert}>
            {({pages}) => {

                if (!pages.length) return 'Loading...';
                return pages.map((page, index)=>
                    <img key={index} src={page}/>
                );
            }}
        </PDFtoIMG>
    </div>
    )
}

export default PDFCert;