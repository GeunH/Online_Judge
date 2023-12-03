function solution(n) {
    let a = n.toString().split('');
    a.sort((a,b)=> b-a);
    return Number(a.join(''));
}
