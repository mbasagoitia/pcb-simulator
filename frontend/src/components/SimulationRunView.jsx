import React, { useState } from "react";
import { Link } from "react-router-dom";
import { Button, Form, InputGroup, Dropdown, Container, Card, Row, Col } from "react-bootstrap";
import { runSimulation } from "../api/simulationApi";

function SimulationRunView() {
  const [boardType, setBoardType] = useState("TestBoard");
  const [count, setCount] = useState(0);
  const [result, setResult] = useState(null);

  async function handleSubmit(e) {
    e.preventDefault();
    const res = await runSimulation({ boardType, count });
    setResult(res);
  }

  const handlePCBSelect = (e) => setBoardType(e);

  function formatPCBName(str) {
    return str
      .replace(/([A-Z])/g, " $1")
      .replace(/^./, (c) => c.toUpperCase())
      .trim();
  }

  return (
    <Container className="my-4">
      <h1 className="mb-4 text-center">Run Simulation</h1>
      <Row className="g-4">
        <Col md={6}>
          <Card className="shadow-sm h-100">
            <Card.Body>
              <Card.Title>Run a New Simulation</Card.Title>
              <Form onSubmit={handleSubmit} className="mt-3">
                <Dropdown onSelect={handlePCBSelect} className="mb-3">
                  <Dropdown.Toggle variant="success">
                    {formatPCBName(boardType)}
                  </Dropdown.Toggle>
                  <Dropdown.Menu>
                    <Dropdown.Item eventKey="TestBoard">Test Board</Dropdown.Item>
                    <Dropdown.Item eventKey="SensorBoard">Sensor Board</Dropdown.Item>
                    <Dropdown.Item eventKey="GatewayBoard">Gateway Board</Dropdown.Item>
                  </Dropdown.Menu>
                </Dropdown>
                <InputGroup className="mb-3">
                  <Form.Control
                    type="number"
                    placeholder="Number of PCBs to Simulate"
                    onChange={(e) => setCount(e.target.value)}
                  />
                </InputGroup>
                <Button type="submit">Run Simulation</Button>
              </Form>
            </Card.Body>
          </Card>
        </Col>
        <Col md={6}>
          <Card className="shadow-sm h-100 d-flex flex-column justify-content-between text-center">
            <Card.Body className="d-flex flex-column justify-content-center">
              <Card.Title>View Existing Simulation Runs</Card.Title>
              <Card.Text className="mt-3">
                Browse all past simulation runs and view detailed reports
              </Card.Text>
              <div className="d-flex justify-content-center">
                <Link to="/runs" className="btn btn-primary mt-2">
                  Simulation Runs
                </Link>
              </div>
            </Card.Body>
          </Card>
        </Col>
      </Row>
      <Row>
      {result && (
        <Card className="shadow-sm mt-4">
          <Card.Body>
            <Card.Title>Simulation Result</Card.Title>
            <pre className="mt-3 bg-light p-3 rounded">
              {JSON.stringify(result, null, 2)}
            </pre>
          </Card.Body>
        </Card>
      )}
      </Row>
    </Container>
  );
}

export default SimulationRunView;