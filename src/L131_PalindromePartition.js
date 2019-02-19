var partition = function(s) {
    let res = [];
    dfs(s, res, [], 0);
    return res;
};

function dfs(s, res, list, pos) {
    if(pos == s.length){
        res.push(list.slice());
        return res;
    }

    for(let i = pos; i < s.length; i++) {
        if(isPalindrome(s, pos, i)) {
            list.push(s.slice(pos, i + 1));
            dfs(s, res, list, i + 1);
            list.pop();
        }
    }
};

function isPalindrome(s, i, j) {
    while(i <= j) {
        if(s[i] !== s[j]) {
            return false;
        }
        i++;
        j--;
    }
    return true;
};