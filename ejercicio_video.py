class Nodo:
    def __init__(self, dato):
        self.dato = dato
        self.siguiente = None


class ColaDinamica:
    def __init__(self):
        self._frente = None
        self._final = None
        self._tamano = 0

    def esta_vacia(self):
        return self._frente is None

    def tamano(self):
        return self._tamano

    def primero(self):
        if self.esta_vacia():
            raise IndexError("La cola está vacía")
        return self._frente.dato

    def enqueue(self, elemento):
        nuevo = Nodo(elemento)
        if self.esta_vacia():
            self._frente = nuevo
        else:
            self._final.siguiente = nuevo
        self._final = nuevo
        self._tamano += 1
        return elemento

    def dequeue(self):
        if self.esta_vacia():
            raise IndexError("La cola está vacía")
        dato = self._frente.dato
        self._frente = self._frente.siguiente
        if self._frente is None:
            self._final = None
        self._tamano -= 1
        return dato

    def __len__(self):
        return self._tamano

    def __str__(self):
        elementos = []
        actual = self._frente
        while actual is not None:
            elementos.append(str(actual.dato))
            actual = actual.siguiente
        return "[" + " <- ".join(elementos) + "]" if elementos else "[cola vacía]"


class Turno:
    def __init__(self, numero, cliente):
        self.numero = numero
        self.cliente = cliente

    def __str__(self):
        return f"T-{self.numero:03d} ({self.cliente})"


def menu():
    print("\n=== GESTIÓN DE TURNOS ===")
    print("1. Generar turno")
    print("2. Atender siguiente turno")
    print("3. Ver siguiente turno")
    print("4. Ver cola de espera")
    print("5. Salir")
    return input("Opción: ").strip()


def main():
    cola = ColaDinamica()
    contador = 1

    while True:
        opcion = menu()

        if opcion == "1":
            cliente = input("Nombre del cliente: ").strip() or "Sin nombre"
            turno = cola.enqueue(Turno(contador, cliente))
            contador += 1
            print(f"Turno generado: {turno}. En espera: {cola.tamano()}")

        elif opcion == "2":
            if cola.esta_vacia():
                print("No hay turnos en espera.")
            else:
                print(f"Atendiendo: {cola.dequeue()}. Restan: {cola.tamano()}")

        elif opcion == "3":
            if cola.esta_vacia():
                print("No hay turnos en espera.")
            else:
                print(f"Siguiente turno: {cola.primero()}")

        elif opcion == "4":
            print(f"Cola ({cola.tamano()}): {cola}")

        elif opcion == "5":
            print("Fin de la simulación.")
            break

        else:
            print("Opción no válida.")


if __name__ == "__main__":
    main()