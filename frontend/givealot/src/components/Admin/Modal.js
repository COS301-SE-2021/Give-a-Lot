import './Modal.css';
import Button from '@material-ui/core/Button';

const Modal = ({ handleClose, show, children }) => {
  const showHideClassName = show ? "modal display-block" : "modal display-none";

  return (
    <div className={showHideClassName}>
      <section className="modal-main">
        {children}
        {/* <button type="submit" onClick={handleClose}>
          Submit
        </button> */}
        <Button variant="contained" color="primary" type="submit" onClick={handleClose}>
            Submit
        </Button>
      </section>
    </div>
  );
};

export default Modal