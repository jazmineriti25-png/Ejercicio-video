const datos = [8, 5, 9, 6, 7];
function burbuja(a) {
  for (let i = 0; i < a.length - 1; i++) {
    let cambio = false;
    for (let j = 0; j < a.length - 1 - i; j++) {
      if (a[j] > a[j + 1]) {
        [a[j], a[j + 1]] = [a[j + 1], a[j]];
        cambio = true;
        console.log('Intercambio:', [...a]);
      }
    }
    console.log('Pasada burbuja:', i + 1, [...a]);
    if (!cambio) break;
  }
  return a;
}
function insercion(a) {
  for (let i = 1; i < a.length; i++) {
    const actual = a[i]; let j = i - 1;
    while (j >= 0 && a[j] > actual) {
      a[j + 1] = a[j]; j--;
    }
    a[j + 1] = actual;
    console.log('Inserción:', i, [...a]);
  }
  return a;
}
function seleccion(a) {
  for (let i = 0; i < a.length - 1; i++) {
    let minimo = i;
    for (let j = i + 1; j < a.length; j++) {
      if (a[j] < a[minimo]) minimo = j;
    }
    if (minimo !== i) [a[i], a[minimo]] = [a[minimo], a[i]];
    console.log('Selección:', i + 1, [...a]);
  }
  return a;
}
function buscar(a, valor) {
  for (let i = 0; i < a.length; i++) {
    if (a[i] === valor) return i;
  }
  return -1;
}
console.log('Original:', datos);
console.log('Burbuja:', burbuja([...datos]));
console.log('Inserción:', insercion([...datos]));
console.log('Selección:', seleccion([...datos]));
console.log('Índice de 7:', buscar(datos, 7));
