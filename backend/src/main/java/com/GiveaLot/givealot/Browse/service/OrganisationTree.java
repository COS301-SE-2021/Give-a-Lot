package com.GiveaLot.givealot.Browse.service;

import com.GiveaLot.givealot.Browse.response.OrganisationTreeResponse;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
class OrganisationTree {
    private OrganisationNode rootNode;
    private List<OrganisationTreeResponse> response = null;

    public OrganisationTree() {
        rootNode = null;
        response = new LinkedList<>();
    }

    public void removeAll() {
        rootNode = null;
    }

    public boolean checkEmpty() {
        if (rootNode == null)
            return true;
        else
            return false;
    }

    public void insertElement(OrganisationData data) {
        rootNode = insertElement(data, rootNode);
    }

    private int getHeight(OrganisationNode node) {
        return node == null ? -1 : node.h;
    }

    // create maxNode() method to get the maximum height from left and right node
    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight) {
        return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;
    }

    // create insertElement() method to insert data in the AVL Tree recursively
    private OrganisationNode insertElement(OrganisationData data, OrganisationNode node) {
        // check whether the node is null or not
        if (node == null) {
            node = new OrganisationNode(data);
        } else if (data.getOrgId().compareTo(node.getOrgId()) < 0) {
            node.leftChild = insertElement(data, node.leftChild);
            if (getHeight(node.leftChild) - getHeight(node.rightChild) == 2) {
                if (data.getOrgId().compareTo(node.leftChild.getOrgId()) < 0) {
                    node = rotateWithLeftChild(node);
                }

                else {
                    node = doubleWithLeftChild(node);
                }
            }
        } else if (data.getOrgId().compareTo(node.getOrgId()) > 0) {
            node.rightChild = insertElement(data, node.rightChild);
            if (getHeight(node.rightChild) - getHeight(node.leftChild) == 2) {
                if (data.getOrgId().compareTo(node.rightChild.getOrgId()) > 0) {
                    node = rotateWithRightChild(node);
                } else {
                    node = doubleWithRightChild(node);
                }
            }
        } else
            ; // if the element is already present in the tree, we will do nothing

        node.h = getMaxHeight(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;

        return node;
    }

    // creating rotateWithLeftChild() method to perform rotation of binary tree node
    // with left child
    private OrganisationNode rotateWithLeftChild(OrganisationNode node2) {
        OrganisationNode node1 = node2.leftChild;
        node2.leftChild = node1.rightChild;
        node1.rightChild = node2;
        node2.h = getMaxHeight(getHeight(node2.leftChild), getHeight(node2.rightChild)) + 1;
        node1.h = getMaxHeight(getHeight(node1.leftChild), node2.h) + 1;
        return node1;
    }

    // creating rotateWithRightChild() method to perform rotation of binary tree
    // node with right child
    private OrganisationNode rotateWithRightChild(OrganisationNode node1) {
        OrganisationNode node2 = node1.rightChild;
        node1.rightChild = node2.leftChild;
        node2.leftChild = node1;
        node1.h = getMaxHeight(getHeight(node1.leftChild), getHeight(node1.rightChild)) + 1;
        node2.h = getMaxHeight(getHeight(node2.rightChild), node1.h) + 1;
        return node2;
    }

    // create doubleWithLeftChild() method to perform double rotation of binary tree
    // node. This method first rotate the left child with its right child, and after
    // that, node3 with the new left child
    private OrganisationNode doubleWithLeftChild(OrganisationNode node3) {
        node3.leftChild = rotateWithRightChild(node3.leftChild);
        return rotateWithLeftChild(node3);
    }

    // create doubleWithRightChild() method to perform double rotation of binary
    // tree node. This method first rotate the right child with its left child and
    // after that node1 with the new right child
    private OrganisationNode doubleWithRightChild(OrganisationNode node1) {
        node1.rightChild = rotateWithLeftChild(node1.rightChild);
        return rotateWithRightChild(node1);
    }

    // create getTotalNumberOfNodes() method to get total number of nodes in the AVL
    // Tree
    public int getTotalNumberOfNodes() {
        return getTotalNumberOfNodes(rootNode);
    }

    private int getTotalNumberOfNodes(OrganisationNode head) {
        if (head == null)
            return 0;
        else {
            int length = 1;
            length = length + getTotalNumberOfNodes(head.leftChild);
            length = length + getTotalNumberOfNodes(head.rightChild);
            return length;
        }
    }

    // create searchElement() method to find an element in the AVL Tree
    public boolean searchElement(String orgId) {
        return searchElement(rootNode, orgId);
    }

    private boolean searchElement(OrganisationNode head, String orgId) {
        boolean check = false;
        while ((head != null) && !check) {
            String headElement = head.getOrgId();
            if (orgId.compareTo(headElement) < 0)
                head = head.leftChild;
            else if (orgId.compareTo(headElement) > 0)
                head = head.rightChild;
            else {
                check = true;
                break;
            }
            check = searchElement(head, orgId);
        }
        return check;
    }

    // create inorderTraversal() method for traversing AVL Tree in in-order form
    public void inorderTraversal() {
        inorderTraversal(rootNode);
    }

    private void inorderTraversal(OrganisationNode head) {
        if (head != null) {
            inorderTraversal(head.leftChild);
            System.out.print(head.getOrgId() + " ");
            inorderTraversal(head.rightChild);
        }
    }

    // create preorderTraversal() method for traversing AVL Tree in pre-order form
    public void preorderTraversal() {
        /*
        * remove an old response
        */
        response.clear();
        build_response(rootNode);
    }

    private void build_response(OrganisationNode head) {
        if (head != null) {
            System.out.print(
                    "debugging: " +
                    head.getOrgId() +
                            " ");
            response.add(new OrganisationTreeResponse(head.getData().getOrgSector(), head.getData()));

            build_response(head.leftChild);
            build_response(head.rightChild);
        }
    }
}