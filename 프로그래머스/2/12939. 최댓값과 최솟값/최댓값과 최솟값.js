function solution(s) {
    var answer = '';
    const a = s.split(" ");
    
    var max = Math.max(...a);
    var min = Math.min(...a);
    return `${min} ${max}`;
}