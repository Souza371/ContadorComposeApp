# 📚 Guia do Professor - Contador Compose

## 🎯 Objetivos Pedagógicos

Este projeto foi desenvolvido para ensinar os conceitos fundamentais do **Jetpack Compose** de forma prática e interativa.

### 🧠 Conceitos Abordados

#### 1. **Estado Reativo (State Management)**
```kotlin
var count by remember { mutableStateOf(0) }
```
- **mutableStateOf()**: Cria uma variável de estado observável
- **remember**: Preserva o estado durante recomposições
- **by**: Delegate property do Kotlin para simplificar acesso

#### 2. **Recomposição Automática**
- Quando `count` muda, todos os componentes que o usam são automaticamente atualizados
- Exemplo: `Text("Valor atual: $count")` se atualiza automaticamente

#### 3. **Layout Declarativo**
```kotlin
Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    // Componentes filhos
}
```

#### 4. **Funções Composables**
- Funções marcadas com `@Composable`
- Descrevem a UI de forma declarativa
- Podem ser reutilizadas e combinadas

## 🏃‍♂️ Roteiro de Aula Sugerido

### **Passo 1: Conceitos Básicos (15 min)**
1. Explicar o que é Jetpack Compose
2. Diferença entre imperativo vs declarativo
3. Conceito de estado reativo
4. Demonstrar o projeto funcionando

### **Passo 2: Análise do Código (20 min)**
1. Abrir `MainActivity.kt`
2. Explicar cada parte:
   - `ComponentActivity`
   - `setContent`
   - Função `ContadorApp()`
   - Estado `mutableStateOf`
   - Layout `Column` e `Row`

### **Passo 3: Prática Guiada (25 min)**
1. Criar projeto do zero (ou usar este como base)
2. Implementar contador básico
3. Adicionar validação (não negativos)
4. Testar no emulador

### **Passo 4: Extensões (Tempo restante)**
- Cores dinâmicas
- Mensagens especiais
- Animações simples

## 🧩 Exercícios Complementares

### **Nível Básico**
1. Mudar o texto do título
2. Alterar cores dos botões
3. Adicionar mais espaçamento
4. Mudar o valor inicial do contador

### **Nível Intermediário**
1. Adicionar botão "Reset"
2. Implementar contador com step de 5
3. Adicionar limite máximo (ex: 100)
4. Mostrar se o número é par ou ímpar

### **Nível Avançado**
1. Implementar múltiplos contadores
2. Adicionar animações
3. Persistir valor usando SharedPreferences
4. Criar temas personalizados

## 🔍 Pontos de Atenção

### **Erros Comuns dos Alunos**

1. **Esquecer `remember`**
   ```kotlin
   // ❌ Errado - valor será resetado a cada recomposição
   var count by mutableStateOf(0)
   
   // ✅ Correto
   var count by remember { mutableStateOf(0) }
   ```

2. **Não usar `by` delegate**
   ```kotlin
   // ❌ Mais verboso
   val count = remember { mutableStateOf(0) }
   Text("Valor: ${count.value}")
   
   // ✅ Mais limpo
   var count by remember { mutableStateOf(0) }
   Text("Valor: $count")
   ```

3. **Confundir `Column` e `Row`**
   - `Column`: organiza verticalmente (um embaixo do outro)
   - `Row`: organiza horizontalmente (um ao lado do outro)

### **Dicas de Debugging**
1. Use o Preview para testar rapidamente
2. Logcat para ver erros de compilação
3. Hot Reload funciona na maioria dos casos
4. Reiniciar app se estado ficar inconsistente

## 📊 Critérios de Avaliação Sugeridos

### **Funcionalidade (40 pontos)**
- [ ] App compila sem erros (10 pts)
- [ ] Contador inicia em 0 (5 pts)
- [ ] Botão + incrementa (10 pts)
- [ ] Botão - decrementa apenas se > 0 (15 pts)

### **Interface (30 pontos)**
- [ ] Layout organizado com Column/Row (10 pts)
- [ ] Título visível (5 pts)
- [ ] Botões funcionais e bem posicionados (10 pts)
- [ ] Valor do contador claramente exibido (5 pts)

### **Código (20 pontos)**
- [ ] Uso correto de `remember { mutableStateOf() }` (10 pts)
- [ ] Função `@Composable` bem estruturada (5 pts)
- [ ] Preview implementado (5 pts)

### **Extras (10 pontos)**
- [ ] Cores dinâmicas (3 pts)
- [ ] Mensagens especiais (3 pts)
- [ ] Validações adicionais (2 pts)
- [ ] Criatividade na interface (2 pts)

## 🚀 Recursos Adicionais

### **Links Úteis**
- [Compose Basics Codelab](https://developer.android.com/codelabs/jetpack-compose-basics)
- [State in Compose](https://developer.android.com/jetpack/compose/state)
- [Layout in Compose](https://developer.android.com/jetpack/compose/layouts)
- [Material 3 Components](https://developer.android.com/jetpack/compose/components)

### **Próximos Tópicos**
1. Navigation in Compose
2. Lists and LazyColumn
3. Theming and Material Design
4. Animation and Gestures
5. Integration with ViewModels

## 🎯 Objetivos de Aprendizagem Atingidos

Ao final desta atividade, os alunos devem ser capazes de:

- ✅ Criar uma Activity com Compose
- ✅ Entender o conceito de estado reativo
- ✅ Usar componentes básicos (Text, Button, Column, Row)
- ✅ Implementar interações simples
- ✅ Testar usando Preview e emulador
- ✅ Organizar código em funções composables
- ✅ Aplicar conceitos de Material Design básico