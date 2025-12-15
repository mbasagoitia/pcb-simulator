import React, { useEffect, useState } from "react";
import { Card, Row, Col, Container, Button } from "react-bootstrap";
import { listRuns } from "../api/simulationApi";
import { Link } from "react-router-dom";

function SimulationQueryView() {
  const [runs, setRuns] = useState([]);

  useEffect(() => {
    listRuns().then(setRuns);
  }, []);

  return (
    <Container>
      <h1 className="my-4 text-center">Past Simulation Runs</h1>

      <div className="mb-4">
        <Link to={"/"} variant="outline-secondary">
          <Button><i className="bi bi-arrow-left"></i>Back</Button>
        </Link>
      </div>

      <Row xs={1} md={2} lg={3} className="g-4">
        {runs.map((run) => (
          <Col key={run.runId}>
            <Card className="shadow-sm h-100">
              <Card.Body>
                <Card.Title>Run #{run.runId}</Card.Title>
                <Card.Subtitle className="mb-2 text-muted">
                  {run.boardType}
                </Card.Subtitle>
                <Card.Text>
                  PCBs Simulated: <strong>{run.pcbsRun}</strong>
                </Card.Text>
                <Link to={`/runs/${run.runId}`} className="btn btn-primary">
                  View Report
                </Link>
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
    </Container>
  );
}

export default SimulationQueryView;