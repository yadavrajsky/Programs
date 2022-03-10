#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
struct node
{
    struct node *lchild;
    int data;
    int height;
    struct node *rchild;
} *root = NULL;

void Inorder(struct node *t)
{
    if (t)
    {
        Inorder(t->lchild);
        printf("%d ", t->data);
        Inorder(t->rchild);
    }
}

int NodeHeight(struct node *p)
{
    int hl, hr;
    hl = p && p->lchild ? p->lchild->height : 1;
    hr = p && p->rchild ? p->rchild->height : 1;
    return hl > hr ? hl + 1 : hr + 1;
}
int BalanceFactor(struct node *p)
{
    int hl, hr;
    hl = p && p->lchild ? p->lchild->height : 0;
    hr = p && p->rchild ? p->rchild->height : 0;
    return hl - hr;
}

struct node *RRRotation(struct node *p)
{
    return NULL;
}
struct node *LRRotation(struct node *p)
{
    struct node *pl = p->lchild;
    struct node *plr = pl->rchild;
    pl->rchild = plr->lchild;
    p->lchild = plr->rchild;
    plr->rchild = p;
    plr->lchild = pl;
    p->height = NodeHeight(p);
    pl->height = NodeHeight(pl);
    plr->height = NodeHeight(plr);
    if (root == p)
        root = plr;
    return plr;
}
struct node *RLRotation(struct node *p)
{
    struct node *pr = p->rchild;
    struct node *prl = pr->lchild;
    pr->lchild = prl->rchild;
    p->rchild = prl->lchild;
    prl->lchild = p;
    prl->rchild = pr;
    p->height = NodeHeight(p);
    pr->height = NodeHeight(pr);
    prl->height = NodeHeight(prl);
    if (root == p)
        root = prl;
    return prl;
}
struct node *LLRotation(struct node *p)
{
    struct node *pl = p->lchild;
    struct node *plr = pl->rchild;
    pl->rchild = p;
    p->lchild = plr;
    p->height = NodeHeight(p);
    pl->height = NodeHeight(pl);
    if (root == p)
        root = pl;
    return pl;
}
struct node *Rinsert(struct node *p, int key)
{
    struct node *temp = NULL;
    if (p == NULL)
    {
        temp = (struct node *)malloc(sizeof(struct node));
        temp->data = key;
        temp->lchild = temp->rchild = NULL;
        temp->height = 1;

        return temp;
    }
    if (key < p->data)
        p->lchild = Rinsert(p->lchild, key);
    else
        p->rchild = Rinsert(p->rchild, key);

    p->height = NodeHeight(p);
    if (BalanceFactor(p) == 2 && BalanceFactor(p->lchild) == 1)
        return LLRotation(p);
    else if (BalanceFactor(p) == 2 && BalanceFactor(p->lchild) == -1)
        return LRRotation(p);
    else if (BalanceFactor(p) == -2 && BalanceFactor(p->rchild) == -1)
        return RRRotation(p);
    else if (BalanceFactor(p) == -2 && BalanceFactor(p->rchild) == 1)
        return RLRotation(p);

    return p;
}

struct node *InPre(struct node *p)
{
    while (p && p->rchild != NULL)
    {
        p = p->rchild;
    }
    return p;
}

struct node *InSucc(struct node *p)
{
    while (p && p->lchild != NULL)
    {
        p = p->lchild;
    }
    return p;
}

struct node *Delete(struct node *p, int key)
{
    struct node *q;
    if (p == NULL)
    {
        return NULL;
    }

    if (p->lchild == NULL && p->rchild == NULL)
    {
        if (p == root)
        {
            root = NULL;
        }
        free(p);
        return NULL;
    }

    if (key < p->data)
    {
        p->lchild = Delete(p->lchild, key);
    }
    else if (key > p->data)
    {
        p->rchild = Delete(p->rchild, key);
    }
    else
    {
        if (NodeHeight(p->lchild) > NodeHeight(p->rchild))
        {
            q = InPre(p->lchild);
            p->data = q->data;
            p->lchild = Delete(p->lchild, q->data);
        }
        else
        {
            q = InSucc(p->rchild);
            p->data = q->data;
            p->rchild = Delete(p->rchild, q->data);
        }
    }

    // Update height
    p->height = NodeHeight(p);

    // Balance Factor and Rotation
    if (BalanceFactor(p) == 2 && BalanceFactor(p->lchild) == 1)
    { // L1 Rotation
        return LLRotation(p);
    }
    else if (BalanceFactor(p) == 2 && BalanceFactor(p->lchild) == -1)
    { // L-1 Rotation
        return LRRotation(p);
    }
    else if (BalanceFactor(p) == -2 && BalanceFactor(p->rchild) == -1)
    { // R-1 Rotation
        return RRRotation(p);
    }
    else if (BalanceFactor(p) == -2 && BalanceFactor(p->rchild) == 1)
    { // R1 Rotation
        return RLRotation(p);
    }
    else if (BalanceFactor(p) == 2 && BalanceFactor(p->lchild) == 0)
    { // L0 Rotation
        return LLRotation(p);
    }
    else if (BalanceFactor(p) == -2 && BalanceFactor(p->rchild) == 0)
    { // R0 Rotation
        return RRRotation(p);
    }

    return p;
}

int main()
{
    // struct node *t;
    // root = Rinsert(root, 50);
    // insert(10);
    // Rinsert(root, 40);
    // insert(20);
    // insert(30);
    // delete (root, 50);
    // Inorder(root);
    // printf("\n");
    root = Rinsert(root, 50);
    Rinsert(root, 60);
    Rinsert(root, 54);
    Delete(root, 60);
    printf("%d ", root->data);
    printf("%d ", root->rchild->data);
    // printf("%d ", root->lchild->data);

    return 0;
}
