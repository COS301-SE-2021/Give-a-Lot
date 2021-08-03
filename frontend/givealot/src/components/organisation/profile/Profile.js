import React from "react";

// react-bootstrap components
import {
    Badge,
    Button,
    Card,
    Form,
    Navbar,
    Nav,
    Container,
    Row,
    Col,
} from "react-bootstrap";

function User() {
    return (
        <>
            <Container fluid>
                <Row>
                    <Col md="8">
                        <Card>
                            <Card.Header>
                                <Card.Title as="h4">Edit Profile</Card.Title>
                            </Card.Header>
                            <Card.Body>
                                <Form>
                                    <Row>
                                        <Col className="pr-1" md="5">
                                            <Form.Group>
                                                <label>Company (disabled)</label>
                                                <Form.Control
                                                    defaultValue="Creative Code Inc."
                                                    disabled
                                                    placeholder="Company"
                                                    type="text"
                                                ></Form.Control>
                                            </Form.Group>
                                        </Col>
                                        <Col className="px-1" md="3">
                                            <Form.Group>
                                                <label>Username</label>
                                                <Form.Control
                                                    defaultValue="michael23"
                                                    placeholder="Username"
                                                    type="text"
                                                ></Form.Control>
                                            </Form.Group>
                                        </Col>
                                        <Col className="pl-1" md="4">
                                            <Form.Group>
                                                <label htmlFor="exampleInputEmail1">
                                                    Email address
                                                </label>
                                                <Form.Control
                                                    placeholder="Email"
                                                    type="email"
                                                ></Form.Control>
                                            </Form.Group>
                                        </Col>
                                    </Row>
                                    <Row>
                                        <Col className="pr-1" md="6">
                                            <Form.Group>
                                                <label>First Name</label>
                                                <Form.Control
                                                    defaultValue="Mike"
                                                    placeholder="Company"
                                                    type="text"
                                                ></Form.Control>
                                            </Form.Group>
                                        </Col>
                                        <Col className="pl-1" md="6">
                                            <Form.Group>
                                                <label>Last Name</label>
                                                <Form.Control
                                                    defaultValue="Andrew"
                                                    placeholder="Last Name"
                                                    type="text"
                                                ></Form.Control>
                                            </Form.Group>
                                        </Col>
                                    </Row>
                                    <Row>
                                        <Col md="12">
                                            <Form.Group>
                                                <label>Address</label>
                                                <Form.Control
                                                    defaultValue="Bld Mihail Kogalniceanu, nr. 8 Bl 1, Sc 1, Ap 09"
                                                    placeholder="Home Address"
                                                    type="text"
                                                ></Form.Control>
                                            </Form.Group>
                                        </Col>
                                    </Row>
                                    <Row>
                                        <Col className="pr-1" md="4">
                                            <Form.Group>
                                                <label>City</label>
                                                <Form.Control
                                                    defaultValue="Mike"
                                                    placeholder="City"
                                                    type="text"
                                                ></Form.Control>
                                            </Form.Group>
                                        </Col>
                                        <Col className="px-1" md="4">
                                            <Form.Group>
                                                <label>Country</label>
                                                <Form.Control
                                                    defaultValue="Andrew"
                                                    placeholder="Country"
                                                    type="text"
                                                ></Form.Control>
                                            </Form.Group>
                                        </Col>
                                        <Col className="pl-1" md="4">
                                            <Form.Group>
                                                <label>Postal Code</label>
                                                <Form.Control
                                                    placeholder="ZIP Code"
                                                    type="number"
                                                ></Form.Control>
                                            </Form.Group>
                                        </Col>
                                    </Row>
                                    <Row>
                                        <Col md="12">
                                            <Form.Group>
                                                <label>About Me</label>
                                                <Form.Control
                                                    cols="80"
                                                    defaultValue="Lamborghini Mercy, Your chick she so thirsty, I'm in
                          that two seat Lambo."
                                                    placeholder="Here can be your description"
                                                    rows="4"
                                                    as="textarea"
                                                ></Form.Control>
                                            </Form.Group>
                                        </Col>
                                    </Row>
                                    <Button
                                        className="btn-fill pull-right"
                                        type="submit"
                                        variant="info"
                                    >
                                        Update Profile
                                    </Button>
                                    <div className="clearfix"></div>
                                </Form>
                            </Card.Body>
                        </Card>
                    </Col>
                    <Col md="4">
                        <Card className="card-user">
                            {/*<div className="card-image">*/}
                            {/*    <img*/}
                            {/*        alt="..."*/}
                            {/*        src="https://pbs.twimg.com/profile_images/1233719885022322689/d6PH_QQ0_400x400.jpg"*/}
                            {/*    />*/}
                            {/*</div>*/}
                            <Card.Body>
                                <div className="author">
                                    <a href="#pablo" onClick={(e) => e.preventDefault()}>
                                        <img
                                            style={{width: "100px", height: "100px", borderRadius: "999px", alignItems: "center"}}
                                            alt="..."
                                            className="avatar border-gray"
                                            src="data:image/jpeg;base64,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"
                                        />
                                        <h5 className="title">Mike Andrew</h5>
                                    </a>
                                    <p className="description">michael24</p>
                                </div>
                                <p className="description text-center">
                                    "Lamborghini Mercy <br />
                                    Your chick she so thirsty <br />
                                    I'm in that two seat Lambo"
                                </p>
                            </Card.Body>
                            <hr></hr>
                            <div className="button-container mr-auto ml-auto">
                                <Button
                                    className="btn-simple btn-icon"
                                    href="#pablo"
                                    onClick={(e) => e.preventDefault()}
                                    variant="link"
                                >
                                    <i className="fab fa-facebook-square"></i>
                                </Button>
                                <Button
                                    className="btn-simple btn-icon"
                                    href="#pablo"
                                    onClick={(e) => e.preventDefault()}
                                    variant="link"
                                >
                                    <i className="fab fa-twitter"></i>
                                </Button>
                                <Button
                                    className="btn-simple btn-icon"
                                    href="#pablo"
                                    onClick={(e) => e.preventDefault()}
                                    variant="link"
                                >
                                    <i className="fab fa-google-plus-square"></i>
                                </Button>
                            </div>
                        </Card>
                    </Col>
                </Row>
            </Container>
        </>
    );
}

export default User;