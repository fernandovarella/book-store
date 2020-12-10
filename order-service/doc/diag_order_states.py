from diagrams import Cluster, Diagram, Edge
from diagrams.aws.compute import ECS

with Diagram(name="Order States", show=False):

    created = ECS("created")
    payment_confirmed = ECS("payment_confirmed")
    preparing_shipment = ECS("preparing_shipment")
    shipped = ECS("shipped")
    delivered = ECS("delivered")
    cancelled = ECS("cancelled")
    returned = ECS("returned")
    finished = ECS("finished")

    created >> Edge(label="confirm_payment") >> payment_confirmed
    payment_confirmed >> Edge(label="cancel_order") >> cancelled
    payment_confirmed >> preparing_shipment
    preparing_shipment >> shipped
    shipped >> delivered
    delivered >> [returned, finished]