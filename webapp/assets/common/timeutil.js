function timestamp2Date(timestamp) {
    var d = new Date(timestamp); //根据时间戳生成的时间对象
    var date = (d.getFullYear()) + "-" +
        (d.getMonth() + 1) + "-" +
        (d.getDate());
    return date;
}