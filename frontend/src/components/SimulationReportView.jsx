import React, { useState, useEffect } from "react";
import { useParams, Link } from "react-router-dom";
import { getRun } from "../api/simulationApi";
import { Card, Row, Col, Container, Spinner, Table, Button } from "react-bootstrap";

function SimulationReportView() {
  const { id } = useParams();
  const [run, setRun] = useState(null);

  useEffect(() => {
    getRun(id).then(setRun);
  }, [id]);

  if (!run)
    return (
      <div className="text-center my-4">
        <Spinner animation="border" />
      </div>
    );

  return (
    <Container className="my-4">

      <h1 className="mb-4 text-center">Run #{id} Report</h1>

      <div className="mb-4">
        <Link to={"/runs"} variant="outline-secondary">
          <Button><i className="bi bi-arrow-left"></i>Back</Button>
        </Link>
      </div>

      <Card className="mb-4 shadow-sm">
        <Card.Body>
          <Card.Title>Summary</Card.Title>
          <Table bordered hover size="sm" className="mt-3">
            <tbody>
              <tr>
                <th>Board Type</th>
                <td>{run.boardType}</td>
              </tr>
              <tr>
                <th>PCBs Run</th>
                <td>{run.pcbsRun}</td>
              </tr>
              <tr>
                <th>Total Successes</th>
                <td>{run.totalSuccesses}</td>
              </tr>
              <tr>
                <th>Total Failures</th>
                <td>{run.totalFailures}</td>
              </tr>
            </tbody>
          </Table>
        </Card.Body>
      </Card>

      <Row>
        <Col md={6}>
          <Card className="shadow-sm mb-4">
            <Card.Body>
              <Card.Title>Station Failures</Card.Title>
              <Table bordered size="sm" className="mt-3">
                <thead>
                  <tr>
                    <th>Station</th>
                    <th>Count</th>
                  </tr>
                </thead>
                <tbody>
                  {run.stationFailures.map((s, i) => (
                    <tr key={i}>
                      <td>{s.name}</td>
                      <td>{s.count}</td>
                    </tr>
                  ))}
                </tbody>
              </Table>
            </Card.Body>
          </Card>
        </Col>

        <Col md={6}>
          <Card className="shadow-sm mb-4">
            <Card.Body>
              <Card.Title>PCB Defect Failures</Card.Title>
              <Table bordered size="sm" className="mt-3">
                <thead>
                  <tr>
                    <th>Station</th>
                    <th>Count</th>
                  </tr>
                </thead>
                <tbody>
                  {run.pcbDefectFailures.map((s, i) => (
                    <tr key={i}>
                      <td>{s.name}</td>
                      <td>{s.count}</td>
                    </tr>
                  ))}
                </tbody>
              </Table>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
}

export default SimulationReportView;