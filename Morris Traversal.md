# Morris Traveral
## Complexity
### Time complexity: O(n)
- 個點最多被訪問兩次
### Space complexity: O(1)
- 使用3個指標，不需要額外空間
## Steps:
1. Initialize current as root
2. **若current有左子樹**，找出current左子樹的最右邊節點，存為pre
3. 將pre的右子樹指向current，左子樹指向null

4. **若current沒有左子樹**，輸出該節點，並將current指向current的右子樹
5. 如果最右邊節點的右子樹是空的，則將其指向current
6. 
![alt text](image.png)
## Inorder Code
```java 
while (cur)
    {
        // if left child exists
        if (cur->left)
        {
            prev=cur->left; // catch hold of left child
           
            while(prev->right) // go to right most node of left child
                prev=prev->right;
        
            prev->right=cur; // make it point to the root

            temp=cur;
            cur=cur->left;

            temp->left=NULL; // make left of root null
        }
        else
        {
            v.push_back(cur->val); // print the node value
            cur=cur->right; // move to right child (because left child doesn't exist)
        }
    }

    return v;
```
## Preorder Code
```java