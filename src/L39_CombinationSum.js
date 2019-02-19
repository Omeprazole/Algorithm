var combinationSum = function(candidates, target) {
    let result = [];
    dfs(result, candidates, target, 0, []);
    return result;
};

function dfs(result, candidates, target, level, list) {
    if(target == 0) {
        result.push(list.slice());
        return result;
    }

    if(level == candidates.length || target < 0) {
        return result;
    }

    for(let i = 0; i <= target/candidates[level]; i++) {
        for(let j = 0; j < i; j++) {
            list.push(candidates[level]);
        }
        dfs(result, candidates, target - candidates[level] * i, level + 1, list);
        for(let j = 0; j < i; j++) {
            list.pop();
        }
    }
};