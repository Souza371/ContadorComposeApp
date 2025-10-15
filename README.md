# 🎯 Contador Compose App

Aplicativo de contador interativo desenvolvido em **Kotlin** com **Jetpack Compose**, demonstrando os conceitos fundamentais de:

- ✅ **Componentes básicos** (Text, Button, Column, Row)
- ✅ **Estado reativo** (mutableStateOf)  
- ✅ **Organização de código** em funções composables
- ✅ **Preview** e execução no emulador
- ✅ **Melhorias adicionais** (cores dinâmicas, mensagens especiais)

## 🚀 Funcionalidades

### Recursos Básicos
- **Título** no topo com o nome do app
- **Contador central** que começa em 0
- **Dois botões**:
  - ➕ **Incrementar**: aumenta o valor
  - ➖ **Decrementar**: diminui o valor (apenas se > 0)

### 🎨 Melhorias Implementadas
- **Cores dinâmicas**: o fundo muda conforme o valor do contador
- **Mensagens especiais**: aparecem em valores específicos (5, 10, 15, 20)
- **Validação**: o contador não pode ser negativo
- **Interface responsiva**: usando Material 3 Design
- **Tema adaptativo**: suporte a modo claro/escuro

## 📱 Como Executar

### Pré-requisitos
- Android Studio Arctic Fox ou superior
- SDK Android 24+ (Android 7.0)
- Emulador Android ou dispositivo físico

### Passos
1. Abra o projeto no Android Studio
2. Aguarde o sync do Gradle
3. Execute o app:
   - Clique em **▶️ Run** no Android Studio
   - Escolha um emulador ou dispositivo
   - Interaja com os botões e observe o contador mudando

## 🧠 Conceitos Aplicados

### Estado Reativo
```kotlin
var count by remember { mutableStateOf(0) }
```
- Cria uma **variável de estado**
- Quando o valor muda, o Compose **recompõe** automaticamente os componentes que usam `count`
- `remember` faz o valor **persistir** entre as recomposições

### Layout Declarativo
```kotlin
Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    Text(...)
    Button(...)
}
```
- **Column** e **Row**: organizam elementos verticalmente e horizontalmente
- **Text** e **Button**: componentes básicos da interface
- **Modifier**: aplica estilização e comportamento

### Preview
```kotlin
@Preview(showBackground = true)
@Composable
fun PreviewContador() {
    ContadorApp()
}
```
- Permite testar o layout **sem executar no emulador**
- Visualização instantânea no Android Studio

## 🎨 Cores Dinâmicas por Valor

| Valor | Cor de Fundo | Significado |
|-------|--------------|-------------|
| < 0   | Rosa claro   | Valores negativos (não permitidos) |
| = 0   | Cinza claro  | Valor inicial |
| 1-5   | Verde claro  | Valores baixos |
| 6-10  | Azul claro   | Valores médios |
| > 10  | Laranja claro| Valores altos |

## 📊 Mensagens Especiais

- **0**: "Comece a contar!" 
- **5**: "Você chegou ao 5! 🎉"
- **10**: "Parabéns! Você chegou a 10! 🎊"
- **15**: "Incrível! 15 é um ótimo número! ⭐"
- **20**: "Uau! 20 pontos! 🚀"

## 🏗️ Estrutura do Projeto

```
ContadorComposeApp/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/contadorcompose/
│   │   │   ├── MainActivity.kt          # Activity principal
│   │   │   └── ui/theme/               # Tema do app
│   │   │       ├── Color.kt
│   │   │       ├── Theme.kt
│   │   │       └── Type.kt
│   │   ├── res/                        # Recursos (strings, temas)
│   │   └── AndroidManifest.xml
│   └── build.gradle                    # Dependências do módulo
├── build.gradle                        # Configuração do projeto
└── settings.gradle                     # Configurações do Gradle
```

## 🧩 Extensões Sugeridas

Para alunos que terminarem rapidamente:

1. **Resetar contador**: botão para voltar ao zero
2. **Histórico**: mostrar valores anteriores
3. **Limite máximo**: definir valor máximo permitido
4. **Animações**: transições suaves entre estados
5. **Sons**: feedback sonoro ao clicar botões
6. **Persistência**: salvar valor ao fechar o app

## 📚 Recursos de Aprendizado

- [Jetpack Compose Docs](https://developer.android.com/jetpack/compose)
- [State in Compose](https://developer.android.com/jetpack/compose/state)
- [Layout Basics](https://developer.android.com/jetpack/compose/layouts/basics)
- [Material 3 Design](https://m3.material.io/)
