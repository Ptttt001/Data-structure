# Search Structures
## AVL tree
### Definition
AVL tree 左子樹高度與右子樹高度差不超過1的二元搜尋樹。
BF值=hL-hR，hL為左子樹高度，hR為右子樹高度。
- 每次insert或delete後，都要檢查BF值
- 會有四種情況需要調整
  - LL: 插入節點在左子樹的左子樹
    左邊比較深，把左子樹提升到root，左子樹的右子樹變成新root的右子數的左邊。
    ![alt text](image-2.png)
  - LR: 插入節點在左子樹的右子樹
    把c往上
    ![alt text](image-4.png)
    ![alt text](image-5.png)
  
  - RR: 插入節點在右子樹的右子樹
    右邊深，把右子樹提升到root，舊root右子樹的左子樹變成新root的左子樹的右邊。
    ![alt text](image-3.png)
  - RL: 插入節點在右子樹的左子樹
![alt text](image.png)
![alt text](image-1.png)
### Complexity
![alt text](image-6.png)
- search for kth item : 參考the k th largest element(用一個新欄位紀錄左子樹的大小+1(自己)的大小，和k比較，k小往左走，k大往右走)
> 建立AVL tree的complexity?